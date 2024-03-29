package leo.study.kotlin_mvp_demo.ui.mvp.fragment.project_article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
import leo.study.kotlin_mvp_demo.R
import leo.study.kotlin_mvp_demo.beans.ArticlePage
import leo.study.kotlin_mvp_demo.databinding.FragmentProjectArticleBinding
import leo.study.kotlin_mvp_demo.ui.activity.CommonWebViewActivity
import leo.study.lib_base.ext.showError
import leo.study.lib_base.ext.showSuccess
import leo.study.lib_base.ext.startActivity
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
    private val projectAdapter by lazy { ProjectArticleAdapter() }


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

        projectAdapter.setOnItemClickListener{_,_,position ->
            val bundle = Bundle()
            bundle.putString("url",projectAdapter.getItem(position)?.link)
            bundle.putString("name",projectAdapter.getItem(position)?.title)
            requireContext().startActivity<CommonWebViewActivity>(bundle)
        }

        projectAdapter.addOnItemChildClickListener(R.id.img_ada_project_article_collect){_,_,position ->
            projectAdapter.getItem(position)?.run {
                if (this.collect){
                    presenter.cancelCollect(this.id.toString(),position)
                }else{
                    presenter.collect(this.id.toString(),position)
                }
            }
        }

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

    override fun onCollectSuccess(position: Int) {
        requireContext().showSuccess("收藏成功！")
        projectAdapter.getItem(position)?.collect = true
        projectAdapter.notifyItemChanged(position)
    }

    override fun onCancelCollectSuccess(position: Int) {
        requireContext().showSuccess("取消收藏！")
        projectAdapter.getItem(position)?.collect = false
        projectAdapter.notifyItemChanged(position)
    }

}