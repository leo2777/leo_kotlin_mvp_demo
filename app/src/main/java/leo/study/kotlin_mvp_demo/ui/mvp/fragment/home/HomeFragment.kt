package leo.study.kotlin_mvp_demo.ui.mvp.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator
import leo.study.kotlin_mvp_demo.beans.ArticlePage
import leo.study.kotlin_mvp_demo.beans.BannerModel
import leo.study.lib_base.mvp.BaseMvpFragment
import leo.study.kotlin_mvp_demo.databinding.FragmentHomeBinding
import leo.study.lib_base.ext.load

/**
 * 首页
 */
class HomeFragment : BaseMvpFragment<FragmentHomeBinding, HomeContract.View,
        HomeContract.Presenter>(), HomeContract.View {

    override var presenter: HomeContract.Presenter = HomePresenter()

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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }


    override fun initView(view: View) {
        setRefresh()
        setBanner()
        setRvAdapter()

        presenter.getHomeData(true)
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
                presenter.getArticles(pageNum)
            }

            override fun onRefresh(refreshLayout: RefreshLayout) {
                pageNum = 0
                presenter.getHomeData(false)
            }
        })
    }


    /**
     * 设置banner
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

        binding.bannerHomeTop.setAdapter(object : BannerImageAdapter<BannerModel>(list) {
            override fun onBindView(
                holder: BannerImageHolder,
                data: BannerModel,
                position: Int,
                size: Int,
            ) {

                holder.imageView.scaleType = ImageView.ScaleType.FIT_XY
                holder.imageView.load(data.imagePath)
                holder.itemView.setOnClickListener {
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

        binding.refreshHome.setNoMoreData(result.over)

        if (pageNum == 0) {
            homeAdapter.submitList(result.articles)
        } else {
            homeAdapter.addAll(result.articles)
        }
    }

}