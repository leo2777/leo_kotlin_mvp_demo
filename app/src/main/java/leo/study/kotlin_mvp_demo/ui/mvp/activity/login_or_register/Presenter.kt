package leo.study.kotlin_mvp_demo.ui.mvp.activity.login_or_register

import leo.study.kotlin_mvp_demo.net.leoSubscribe
import leo.study.lib_base.ext.showWarning
import leo.study.lib_base.mvp.BasePresenter


/**
 *
 * ***********************************************************************
 *the project desc: 登录注册 P层
 *this name is Presenter
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年03月27日 14:30:27
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class Presenter:BasePresenter<Contract.View>(),Contract.Presenter {


    override fun change() {
        view?.onChangeResult()
    }

    override fun login(name: String, password: String) {

        if (name.isEmpty()){
            getContext()?.showWarning("请输入用户名！！")
            return
        }

        if (password.isEmpty()){
            getContext()?.showWarning("请输入密码！！")
            return
        }


        model?.login(name,password)?.leoSubscribe(view,model,true) {
            view?.onLoginResult(it.data)
        }
    }

    override fun register(name: String, password: String, rePassword: String) {

        if (name.isEmpty()){
            getContext()?.showWarning("请输入用户名！！")
            return
        }

        if (password.isEmpty()){
            getContext()?.showWarning("请输入密码！！")
            return
        }

        if (rePassword.isEmpty()){
            getContext()?.showWarning("请输入确认密码！！")
            return
        }

        if (password != rePassword){
            getContext()?.showWarning("密码两次输入不一致！！")
            return
        }



        model?.register(name, password, rePassword)?.leoSubscribe(view,model,true) {
            view?.onRegisterResult(it.data)
        }
    }

    override var model: Contract.Model? = Model()
}