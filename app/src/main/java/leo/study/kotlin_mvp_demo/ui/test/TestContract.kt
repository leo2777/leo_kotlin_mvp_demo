package leo.study.kotlin_mvp_demo.ui.test

import io.reactivex.Observable
import leo.study.lib_base.mvp.IModel
import leo.study.lib_base.mvp.IPresenter
import leo.study.lib_base.mvp.IView


/**
 *
 * ***********************************************************************
 *the project desc: 测试mvp契约类
 *this name is TestContract
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2022年12月28日 10:28:54
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
interface TestContract {

    interface View : IView<Presenter>{
        fun getDataSuccess(msg: String?)
    }
    interface Presenter : IPresenter<View,Model> {
        fun getData()
    }
    interface Model : IModel {
        fun getData(): Observable<TestBean>
    }
}