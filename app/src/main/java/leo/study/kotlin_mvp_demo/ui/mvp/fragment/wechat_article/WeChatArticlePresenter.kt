package leo.study.kotlin_mvp_demo.ui.mvp.fragment.wechat_article

import leo.study.kotlin_mvp_demo.net.leoSubscribe
import leo.study.lib_base.mvp.BasePresenter


/**
 *
 * ***********************************************************************
 *the project desc: 公众号-个人文章列表 P层
 *this name is WeChatArticlePresenter
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月08日 13:57:53
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class WeChatArticlePresenter:BasePresenter<WeChatArticleContract.View>(),
WeChatArticleContract.Presenter{


override var model: WeChatArticleContract.Model? = WeChatArticleModel()

    override fun refresh(authorId: String) {
        model?.getArticles(authorId,1)?.leoSubscribe(view,model) {
            view?.getArticleSuccess(it.data)
        }
    }

    override fun load(authorId: String, page: Int) {
        model?.getArticles(authorId, page)?.leoSubscribe(view,model) {
            view?.getArticleSuccess(it.data)
        }
    }

}