package leo.study.kotlin_mvp_demo.ui.mvp.fragment.wechat_article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
import leo.study.kotlin_mvp_demo.beans.ArticlePage
import leo.study.kotlin_mvp_demo.databinding.FragmentWeChatArticleBinding
import leo.study.kotlin_mvp_demo.ui.mvp.fragment.home.HomeArticleAdapter
import leo.study.lib_base.ext.showError
import leo.study.lib_base.mvp.BaseMvpFragment


/**
 *
 * ***********************************************************************
 *the project desc: 公众号-个人发布列表
 *this name is WeChatArticleFragment
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月08日 11:48:02
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class WeChatArticleFragment : BaseMvpFragment<FragmentWeChatArticleBinding,
        WeChatArticleContract.View,
        WeChatArticleContract.Presenter>(), WeChatArticleContract.View {

    private val firstPage = 1
    private var page:Int = firstPage //页码数，从「1」开始
    private var authorId:String = ""
    private val adapter by lazy { HomeArticleAdapter() }

    override var presenter: WeChatArticleContract.Presenter = WeChatArticlePresenter()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentWeChatArticleBinding {
       return FragmentWeChatArticleBinding.inflate(inflater,container,false)
    }

    override fun setArguments(args: Bundle?) {
        super.setArguments(args)
        authorId = args!!.getString("authorId","")
    }

    override fun initView(view: View) {
        binding.refreshWeChat.setOnRefreshLoadMoreListener(object:OnRefreshLoadMoreListener{
            override fun onRefresh(refreshLayout: RefreshLayout) {
                page = firstPage
                presenter.refresh(authorId)
            }

            override fun onLoadMore(refreshLayout: RefreshLayout) {
                presenter.load(authorId,page++)
            }

        })

        binding.recWeChatArticlesList.adapter = this.adapter
    }

    override fun lazyLoad() {
        if (authorId.isEmpty()){
            mContext?.showError("缺少重要参数！！")
            return
        }
        presenter.refresh(authorId)
    }

    override fun getArticleSuccess(result: ArticlePage) {
        //结束刷新和加载
        binding.refreshWeChat.finishRefresh()
        binding.refreshWeChat.finishLoadMore()

        binding.refreshWeChat.setNoMoreData(result.over)

        if (page == 0) {
            adapter.submitList(result.articles)
        } else {
            adapter.addAll(result.articles)
        }
    }
}