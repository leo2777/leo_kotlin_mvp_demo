package leo.study.kotlin_mvp_demo.ui.mvp.fragment.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.orhanobut.logger.Logger
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator
import leo.study.kotlin_mvp_demo.beans.ArticlePage
import leo.study.kotlin_mvp_demo.beans.Articles
import leo.study.kotlin_mvp_demo.beans.BannerModel
import leo.study.kotlin_mvp_demo.databinding.AdapterHomeArticleBinding
import leo.study.lib_base.mvp.BaseMvpFragment
import leo.study.kotlin_mvp_demo.databinding.FragmentHomeBinding
import leo.study.lib_base.image.ImageLoaderHelper

/**
 * 首页
 */
class HomeFragment : BaseMvpFragment<FragmentHomeBinding, HomeContact.View,
        HomeContact.Presenter>(), HomeContact.View {

    override var presenter: HomeContact.Presenter = HomePresenter()

    //页数
    private var pageNum: Int = 0

    //总页数，每次获取数据设置，用于判断加载完全部
    private var pageCount: Int = 0


    private val homeAdapter by lazy { HomeArticleAdapter() }

    /**
     * 绑定当前的fragment
     *
     * @param [inflater] 布局
     * @param [container] 父类
     * @return 绑定
     */
    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?)
            : FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }


    override fun initView(view: View) {
        setRefresh()
        setBanner()
        setRvAdapter()
        presenter.getHomeData()
    }

    override fun lazyLoad() {
    }

    /**
     * 设置刷新控件  （刷新，加载更多）
     *
     */
    private fun setRefresh() {
        binding.refreshHome.setOnRefreshLoadMoreListener(object : OnRefreshLoadMoreListener {
            override fun onLoadMore(refreshLayout: RefreshLayout) {
                pageNum++
                //加载完所有数据
                if (pageCount != 0 && pageNum > pageCount) {
                    pageNum = pageCount
                    refreshLayout.setNoMoreData(true)
                    return
                }
                presenter.getArticles(pageNum)
            }

            override fun onRefresh(refreshLayout: RefreshLayout) {
                pageNum = 0
                presenter.getHomeData()
            }
        })
    }


    /**
     * 设置banner
     * todo: 后续设置banner切换 改变状态栏颜色
     */
    private fun setBanner() {
        binding.bannerHomeTop.setOnBannerListener { data, position ->
            val model: BannerModel = data as BannerModel
        }
    }

    private fun setRvAdapter() {
        binding.recHomeList.adapter = homeAdapter
    }


    /**
     * 首页banner数据获取成功回调
     *
     * @param [list] 数据实体
     */
    override fun getBannerSuccess(list: List<BannerModel>) {

        binding.bannerHomeTop.setAdapter(object : BannerImageAdapter<BannerModel?>(list) {
            override fun onBindView(
                holder: BannerImageHolder?,
                data: BannerModel?,
                position: Int,
                size: Int,
            ) {
                holder?.imageView?.scaleType = ImageView.ScaleType.FIT_XY
                ImageLoaderHelper.instance.loadImage(holder?.imageView, data?.imagePath)
                holder?.itemView?.setOnClickListener {
                    //todo:这里后续需要完善 跳转网页显示的 Activity
                }
            }
        })
            .addBannerLifecycleObserver(this)
            .indicator = CircleIndicator(context)
    }

    /**
     * 首页 文章列表数据
     *
     * @param [result] 文章数据
     */
    override fun getListDataSuccess(result: ArticlePage) {
        //结束刷新和加载
        binding.refreshHome.finishRefresh()
        binding.refreshHome.finishLoadMore()
        //获取总页数
        pageCount = result.pageCount

        if (pageNum == 0) {
            homeAdapter.submitList(result.datas)
        } else {
            homeAdapter.addAll(result.datas)
        }
    }

}