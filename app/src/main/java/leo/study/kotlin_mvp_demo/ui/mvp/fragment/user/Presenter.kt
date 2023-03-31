package leo.study.kotlin_mvp_demo.ui.mvp.fragment.user

import leo.study.kotlin_mvp_demo.net.leoSubscribe
import leo.study.kotlin_mvp_demo.net.resultSubscribe
import leo.study.lib_base.mvp.BasePresenter


/**
 *
 * ***********************************************************************
 *the project desc: P层
 *this name is Presenter
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年03月28日 10:14:59
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class Presenter:BasePresenter<Contract.View>(),Contract.Presenter {


    override fun getUserInfo() {
        model?.getUserInfo()?.leoSubscribe(view,model,true) {
            view?.onUserInfoResult(it.data)
        }
    }

    override fun getIsLogin() {
        view?.let {view ->
            model?.getIsLogin(getContext()!!)?.resultSubscribe(view) {
                view.onIsLogin(it)
            }
        }
    }

    override var model: Contract.Model? = Model()
}