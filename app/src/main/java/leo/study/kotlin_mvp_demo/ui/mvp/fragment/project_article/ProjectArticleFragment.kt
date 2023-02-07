package leo.study.kotlin_mvp_demo.ui.mvp.fragment.project_article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
import leo.study.kotlin_mvp_demo.beans.ArticlePage
import leo.study.kotlin_mvp_demo.databinding.FragmentProjectArticleBinding
import leo.study.lib_base.ext.showError
import leo.study.lib_base.mvp.BaseMvpFragment


/**
 *
 * ***********************************************************************
 *the project desc: 项目，子页面 。（项目列表）
 *this name is ProjectArticleFragment
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月07日 14:57:43
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class ProjectArticleFragment : BaseMvpFragment<
        FragmentProjectArticleBinding,
        ProjectArticleContract.View,
        ProjectArticleContract.Presenter>(), ProjectArticleContract.View {

    private val firstPage = 1
    private var page:Int = firstPage //页码数，从「1」开始
    private var cId:String = ""
    private var projectAdapter:ProjectArticleAdapter = ProjectArticleAdapter()


    override var presenter: ProjectArticleContract.Presenter = ProjectArticlePresenter()


    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentProjectArticleBinding {
        return FragmentProjectArticleBinding.inflate(inflater, container, false)
    }

    override fun setArguments(args: Bundle?) {
        super.setArguments(args)
        cId = args!!.getString("id","")
    }

    override fun initView(view: View) {

        binding.refreshProject.setOnRefreshLoadMoreListener(object :OnRefreshLoadMoreListener{
            override fun onRefresh(refreshLayout: RefreshLayout) {
                lazyLoad()
            }

            override fun onLoadMore(refreshLayout: RefreshLayout) {
                page++
                presenter.getArticles(page,cId)
            }

        })

        binding.recProjectArticlesList.adapter = this.projectAdapter
    }

    override fun lazyLoad() {
        if (cId.isEmpty()) {
            mContext!!.showError("缺少必要参数！！")
            return
        }
        page = firstPage
        presenter.getArticles(page,cId)
    }

    override fun getArticleSuccess(result: ArticlePage) {
        //结束刷新和加载
        binding.refreshProject.finishRefresh()
        binding.refreshProject.finishLoadMore()

        binding.refreshProject.setNoMoreData(result.over)

        if (page == firstPage) {
            projectAdapter.submitList(result.articles)
        } else {
            projectAdapter.addAll(result.articles)
        }
    }

}