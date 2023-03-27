package leo.study.kotlin_mvp_demo.ui.mvp.activity.login_or_register

import io.reactivex.Observable
import leo.study.kotlin_mvp_demo.beans.LoginAndRegisterBean
import leo.study.kotlin_mvp_demo.common.BaseRequest
import leo.study.lib_base.mvp.IModel
import leo.study.lib_base.mvp.IPresenter
import leo.study.lib_base.mvp.IView


/**
 *
 * ***********************************************************************
 *the project desc: 登录或者注册页面契约类
 *this name is Contract
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年03月27日 11:45:40
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
interface Contract {


    interface View:IView<Presenter>{
        fun onLoginResult(bean:LoginAndRegisterBean)

        fun onRegisterResult(bean: LoginAndRegisterBean)

        fun onChangeResult()
    }



    interface Presenter:IPresenter<View,Model>{
        fun change()

        fun login(name:String,password: String)

        fun register(name: String,password: String,rePassword: String)
    }


    interface Model:IModel{
        fun login(name:String,password:String):Observable<BaseRequest<LoginAndRegisterBean>>

        fun register(name:String,password:String,rePassword:String):Observable<BaseRequest<LoginAndRegisterBean>>
    }
}