package leo.study.kotlin_mvp_demo.ui.mvp.fragment.more_square

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
import leo.study.kotlin_mvp_demo.R
import leo.study.kotlin_mvp_demo.beans.ArticlePage
import leo.study.kotlin_mvp_demo.databinding.FragmentSquareBinding
import leo.study.kotlin_mvp_demo.ui.activity.CommonWebViewActivity
import leo.study.kotlin_mvp_demo.ui.mvp.fragment.home.HomeArticleAdapter
import leo.study.lib_base.ext.showSuccess
import leo.study.lib_base.ext.startActivity
import leo.study.lib_base.mvp.BaseMvpFragment


/**
 *
 * ***********************************************************************
 *the project desc: 更多fragment - 广场 fragment
 *this name is SquareFragment
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月08日 15:36:05
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class SquareFragment : BaseMvpFragment<
        FragmentSquareBinding,
        SquareContract.View,
        SquareContract.Presenter>(), SquareContract.View {

    private val pageFirst = 0
    private var page = pageFirst
    private val adapter: HomeArticleAdapter by lazy { HomeArticleAdapter() }


    override var presenter: SquareContract.Presenter = SquarePresenter()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSquareBinding {
        return FragmentSquareBinding.inflate(inflater, container, false)
    }

    override fun initView(view: View) {
        binding.refreshMoreSquare.setOnRefreshLoadMoreListener(object : OnRefreshLoadMoreListener {
            override fun onRefresh(refreshLayout: RefreshLayout) {
                page = pageFirst
                presenter.refresh()
            }

            override fun onLoadMore(refreshLayout: RefreshLayout) {
                presenter.load(page++)
            }

        })

        binding.recMoreSquareArticlesList.adapter = this.adapter

        adapter.setOnItemClickListener { _, _, position ->
            val bundle = Bundle()
            bundle.putString("url", adapter.getItem(position)?.link)
            bundle.putString("name", adapter.getItem(position)?.title)
            requireContext().startActivity<CommonWebViewActivity>(bundle)
        }

        adapter.addOnItemChildClickListener(R.id.img_ada_home_article_collect) { _, _, position ->
            adapter.getItem(position)?.run {
                if (this.collect) {
                    presenter.cancelCollect(this.id.toString(), position)
                } else {
                    presenter.collect(this.id.toString(), position)
                }
            }
        }

        page = pageFirst
        presenter.getData()
    }

    override fun lazyLoad() {
    }


    override fun onResult(result: ArticlePage) {
        binding.refreshMoreSquare.finishRefresh()
        binding.refreshMoreSquare.finishLoadMore()

        binding.refreshMoreSquare.setNoMoreData(result.over)

        if (page == pageFirst) {
            adapter.submitList(result.articles)
        } else {
            adapter.addAll(result.articles)
        }
    }

    override fun onCollectSuccess(position: Int) {
        requireContext().showSuccess("收藏成功！")
        adapter.getItem(position)?.collect = true
        adapter.notifyItemChanged(position)
    }

    override fun onCancelCollectSuccess(position: Int) {
        requireContext().showSuccess("取消收藏！")
        adapter.getItem(position)?.collect = false
        adapter.notifyItemChanged(position)
    }

}