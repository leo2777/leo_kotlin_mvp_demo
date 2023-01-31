package leo.study.kotlin_mvp_demo.ui.mvp.fragment.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.orhanobut.logger.Logger
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator
import leo.study.lib_base.mvp.BaseMvpFragment
import leo.study.kotlin_mvp_demo.databinding.FragmentHomeBinding
import leo.study.kotlin_mvp_demo.model.home.BannerModel
import leo.study.lib_base.image.ImageLoaderHelper


/**
 * 首页
 */
class HomeFragment : BaseMvpFragment<FragmentHomeBinding, HomeContact.View,
        HomeContact.Presenter>(), HomeContact.View {




    override var presenter: HomeContact.Presenter = HomePresenter()


    /**
     * 绑定当前的fragment
     *
     * @param [inflater] 布局
     * @param [container] 父类
     * @return 绑定
     */
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }


    override fun initView(view: View) {
        setRefresh()
        presenter.getBanner()
    }

    override fun lazyLoad() {
    }

    /**
     * 获取页面列表数据
     *
     */
    private fun getData() {

    }

    /**
     * 设置刷新控件  （刷新，加载更多）
     *
     */
    private fun setRefresh() {
        binding.refreshHome.setOnRefreshLoadMoreListener(object : OnRefreshLoadMoreListener {
            override fun onLoadMore(refreshLayout: RefreshLayout) {
            }

            override fun onRefresh(refreshLayout: RefreshLayout) {

            }
        })
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
                ImageLoaderHelper.instance.loadImage(holder?.imageView, data?.imagePath)
                holder?.itemView?.setOnClickListener {
                    //todo:这里后续需要完善 跳转网页显示的 Activity
                }
            }
        })
            .addBannerLifecycleObserver(this)
            .indicator = CircleIndicator(context)
    }

}