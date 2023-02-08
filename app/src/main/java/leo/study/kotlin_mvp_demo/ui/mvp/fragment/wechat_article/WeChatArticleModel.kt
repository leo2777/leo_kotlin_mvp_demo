package leo.study.kotlin_mvp_demo.ui.mvp.fragment.wechat_article

import io.reactivex.Observable
import leo.study.kotlin_mvp_demo.beans.ArticlePage
import leo.study.kotlin_mvp_demo.common.BaseRequest
import leo.study.kotlin_mvp_demo.net.MainRetrofit
import leo.study.lib_base.mvp.BaseModel


/**
 *
 * ***********************************************************************
 *the project desc: 公众号-个人列表 。M层
 *this name is WeChatArticleModel
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月08日 13:50:17
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class WeChatArticleModel : BaseModel(),WeChatArticleContract.Model {

    override fun getArticles(authorId: String, page: Int): Observable<BaseRequest<ArticlePage>> {
        return MainRetrofit().apiService.getWeChatArticle(authorId,page)
    }
}