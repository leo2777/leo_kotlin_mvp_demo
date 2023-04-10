package leo.study.kotlin_mvp_demo.ui.mvp.fragment.wechat

import io.reactivex.Observable
import leo.study.kotlin_mvp_demo.beans.ArticleCategory
import leo.study.kotlin_mvp_demo.common.BaseRequest
import leo.study.lib_base.mvp.IModel
import leo.study.lib_base.mvp.IPresenter
import leo.study.lib_base.mvp.IView


/**
 *
 * ***********************************************************************
 *the project desc: 公众号 契约类
 *this name is WeChatContract
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月08日 11:06:51
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
interface WeChatContract {

    interface View : IView<Presenter> {
        /**
         * 请求成功 数据回调
         *
         * @param result 数据实体
         */
        fun getCategorySuccess(result:MutableList<ArticleCategory>)
    }

    interface Presenter : IPresenter<View, Model> {
        /**
         * 获取数据
         *
         */
        fun getCategory()
    }

    interface Model : IModel {
        /**
         * 获取数据
         *
         * @return
         */
        fun getCategory(): Observable<BaseRequest<MutableList<ArticleCategory>>>
    }
}