package leo.study.kotlin_mvp_demo.ui.mvp.fragment.project_article

import io.reactivex.Observable
import leo.study.kotlin_mvp_demo.beans.ArticlePage
import leo.study.kotlin_mvp_demo.beans.Articles
import leo.study.kotlin_mvp_demo.common.BaseRequest
import leo.study.lib_base.mvp.IModel
import leo.study.lib_base.mvp.IPresenter
import leo.study.lib_base.mvp.ITopModel
import leo.study.lib_base.mvp.IView


/**
 *
 * ***********************************************************************
 *the project desc: 项目- 子页面- 项目列表契约类
 *this name is ProjectArticleContract
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月07日 17:27:23
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
interface ProjectArticleContract {

    interface View:IView<Presenter>{
        /**
         * 列表数据获取成功之后回调
         *
         * @param result 结果数据实体
         */
        fun getArticleSuccess(result:ArticlePage)
    }


    interface Presenter:IPresenter<View,Model>{
        /**
         * 获取项目分类下 列表数据
         *
         * @param page 页数
         * @param id 类ID
         */
        fun getArticles(page:Int,id:String)
    }

    interface Model:IModel{
        /**
         * 获取项目分类下 列表数据
         *
         * @param page 页数
         * @param id 类ID
         * @return 列表数据实体
         */
        fun getArticles(page:Int,id:String): Observable<BaseRequest<ArticlePage>>
    }
}