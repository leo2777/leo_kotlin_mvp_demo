package leo.study.kotlin_mvp_demo.ui.mvp.fragment.wechat_article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
import leo.study.kotlin_mvp_demo.R
import leo.study.kotlin_mvp_demo.beans.ArticlePage
import leo.study.kotlin_mvp_demo.databinding.FragmentWeChatArticleBinding
import leo.study.kotlin_mvp_demo.ui.activity.CommonWebViewActivity
import leo.study.kotlin_mvp_demo.ui.mvp.fragment.home.HomeArticleAdapter
import leo.study.lib_base.ext.showError
import leo.study.lib_base.ext.showSuccess
import leo.study.lib_base.ext.startActivity
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


        adapter.setOnItemClickListener{_,_,position ->
            val bundle = Bundle()
            bundle.putString("url",adapter.getItem(position)?.link)
            bundle.putString("name",adapter.getItem(position)?.title)
            requireContext().startActivity<CommonWebViewActivity>(bundle)
        }

        adapter.addOnItemChildClickListener(R.id.img_ada_home_article_collect){ _,_,position ->
            adapter.getItem(position)?.run {
                if (this.collect){
                    presenter.cancelCollect(this.id.toString(),position)
                }else{
                    presenter.collect(this.id.toString(),position)
                }
            }
        }

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

        if (page == firstPage) {
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