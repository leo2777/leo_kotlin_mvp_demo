package leo.study.lib_base.mvp


/**
 *
 * ***********************************************************************
 *the project desc: P层
 *this name is BasePresenter
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2022年11月08日 14:23:18
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
open class BasePresenter<V : ITopView> {
    var view: V? = null
}