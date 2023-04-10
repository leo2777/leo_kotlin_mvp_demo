package leo.study.kotlin_mvp_demo.ui.mvp.fragment.wechat_article

import io.reactivex.Observable
import leo.study.kotlin_mvp_demo.beans.ArticlePage
import leo.study.kotlin_mvp_demo.common.BaseRequest
import leo.study.lib_base.mvp.IModel
import leo.study.lib_base.mvp.IPresenter
import leo.study.lib_base.mvp.IView


/**
 *
 * ***********************************************************************
 *the project desc: 公众号-个人文章列表契约类
 *this name is WeChatArticleContract
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月08日 13:51:01
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
interface WeChatArticleContract {

    interface View:IView<Presenter>{
        fun getArticleSuccess(result:ArticlePage)


        fun onCollectSuccess(position: Int)

        fun onCancelCollectSuccess(position: Int)
    }


    interface Presenter:IPresenter<View,Model>{
        fun refresh(authorId: String)

        fun load(authorId: String,page: Int)

        fun collect(id: String,position: Int)

        fun cancelCollect(id: String,position: Int)
    }

    interface Model:IModel{
        fun getArticles(authorId:String,page:Int):Observable<BaseRequest<ArticlePage>>


        fun collect(id: String): Observable<BaseRequest<Any>>

        fun cancelCollect(id: String): Observable<BaseRequest<Any>>
    }
}