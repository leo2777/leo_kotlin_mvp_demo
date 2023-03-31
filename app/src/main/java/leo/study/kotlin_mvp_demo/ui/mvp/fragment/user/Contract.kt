package leo.study.kotlin_mvp_demo.ui.mvp.fragment.user

import android.content.Context
import android.view.Display.Mode
import io.reactivex.Observable
import leo.study.kotlin_mvp_demo.beans.UserInfoBean
import leo.study.kotlin_mvp_demo.common.BaseRequest
import leo.study.lib_base.mvp.IModel
import leo.study.lib_base.mvp.IPresenter
import leo.study.lib_base.mvp.IView


/**
 *
 * ***********************************************************************
 *the project desc: 个人页面契约类
 *this name is Contract
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年03月28日 10:10:09
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
interface Contract {

    interface View:IView<Presenter>{
        fun onUserInfoResult(result:UserInfoBean)
        fun onIsLogin(login:Boolean)
    }


    interface Presenter:IPresenter<View,Model>{
        fun getUserInfo()
        fun getIsLogin()
    }

    interface Model:IModel{
        fun getIsLogin(context: Context):Observable<Boolean>
        fun getUserInfo():Observable<BaseRequest<UserInfoBean>>
    }
}