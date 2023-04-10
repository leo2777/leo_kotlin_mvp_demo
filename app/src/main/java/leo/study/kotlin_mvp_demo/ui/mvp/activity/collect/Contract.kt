package leo.study.kotlin_mvp_demo.ui.mvp.activity.collect

import io.reactivex.Observable
import leo.study.kotlin_mvp_demo.beans.ArticlePage
import leo.study.kotlin_mvp_demo.beans.Articles
import leo.study.kotlin_mvp_demo.common.BaseRequest
import leo.study.lib_base.mvp.IModel
import leo.study.lib_base.mvp.IPresenter
import leo.study.lib_base.mvp.IView


/**
 *
 * ***********************************************************************
 *the project desc: 我的收藏 契约类
 *this name is Contract
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年04月10日 14:55:12
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
interface Contract {


    interface View:IView<Presenter>{

        fun onMyCollectList(result:ArticlePage)

    }

    interface Presenter:IPresenter<View,Model>{

        fun refreshList()

        fun loadList(page:Int)

    }

    interface Model:IModel{
        fun getMyCollectList(page:Int):Observable<BaseRequest<ArticlePage>>
    }
}