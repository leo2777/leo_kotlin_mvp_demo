package leo.study.kotlin_mvp_demo.ui.mvp.fragment.home

import io.reactivex.Observable
import leo.study.kotlin_mvp_demo.beans.ArticlePage
import leo.study.kotlin_mvp_demo.beans.Articles
import leo.study.kotlin_mvp_demo.beans.BannerModel
import leo.study.kotlin_mvp_demo.common.BaseRequest
import leo.study.lib_base.mvp.IModel
import leo.study.lib_base.mvp.IPresenter
import leo.study.lib_base.mvp.IView


/**
 *
 * ***********************************************************************
 *the project desc: 首页 fragment 契约类
 *this name is HomeContact
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年01月31日 10:45:12
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
interface HomeContact {

    interface View : IView<Presenter>{
        /**
         * 请求成功数据返回
         *
         * @param [list] 数据实体
         */
        fun getBannerSuccess(list: List<BannerModel>)

        /**
         * 获取列表数据成功返回 （置顶列表和文章列表）
         *
         * @param [list] 数据实体
         */
        fun getListDataSuccess(result:ArticlePage)
    }

    interface Presenter: IPresenter<View,Model>{
        /**
         * 获取banner数据
         *
         */
        fun getBanner()

        /**
         * 获取页面所有数据
         *
         */
        fun getHomeData()

        /**
         * 获取文章列表
         *
         * @param [pageNum] 页码
         */
        fun getArticles(pageNum:Int)


    }

    interface Model : IModel{
        /**
         * 获取banner数据
         *
         * @return 数据实体
         */
        fun getBanner():Observable<BaseRequest<MutableList<BannerModel>>>

        fun getArticles(pageNum:Int):Observable<BaseRequest<ArticlePage>>

        /**
         * 获取置顶文章列表
         *
         * @return 数据实体
         */
        fun getTopArticles():Observable<BaseRequest<MutableList<Articles>>>

    }
}