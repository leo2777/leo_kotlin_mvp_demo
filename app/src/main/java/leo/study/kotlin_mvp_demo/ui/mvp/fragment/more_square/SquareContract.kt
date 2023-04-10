package leo.study.kotlin_mvp_demo.ui.mvp.fragment.more_square

import io.reactivex.MaybeObserver
import io.reactivex.Observable
import leo.study.kotlin_mvp_demo.beans.ArticlePage
import leo.study.kotlin_mvp_demo.common.BaseRequest
import leo.study.lib_base.mvp.IModel
import leo.study.lib_base.mvp.IPresenter
import leo.study.lib_base.mvp.IView


/**
 *
 * ***********************************************************************
 *the project desc: 广场页面 契约类
 *this name is SquareConstract
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月08日 16:43:09
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
interface SquareContract {

    interface View:IView<Presenter>{
        /**
         * 数据请求成功之后
         * 结果回调
         *
         * @param result 数据实体
         */
        fun onResult(result: ArticlePage)

        fun onCollectSuccess(position: Int)

        fun onCancelCollectSuccess(position: Int)
    }


    interface Presenter:IPresenter<View,Model>{

        fun getData()


        /**
         * 刷新
         *
         */
        fun refresh()

        /**
         * 加载更多
         *
         * @param page 页数
         */
        fun load(page:Int)


        fun collect(id: String,position: Int)


        fun cancelCollect(id: String,position: Int)
    }

    interface Model:IModel{
        /**
         * 获取数据
         *
         * @param page 页码
         * @return 数据实体
         */
        fun getArticles(page:Int):Observable<BaseRequest<ArticlePage>>

        fun collect(id: String):Observable<BaseRequest<Any>>

        fun cancelCollect(id: String):Observable<BaseRequest<Any>>
    }
}