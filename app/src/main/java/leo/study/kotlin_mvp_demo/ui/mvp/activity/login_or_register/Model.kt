package leo.study.kotlin_mvp_demo.ui.mvp.activity.login_or_register

import io.reactivex.Observable
import leo.study.kotlin_mvp_demo.beans.LoginAndRegisterBean
import leo.study.kotlin_mvp_demo.common.BaseRequest
import leo.study.kotlin_mvp_demo.net.MainRetrofit
import leo.study.lib_base.mvp.BaseModel


/**
 *
 * ***********************************************************************
 *the project desc: 登录注册 。M层
 *this name is Model
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年03月27日 14:28:12
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class Model:BaseModel(),Contract.Model {


    override fun login(
        name: String,
        password: String
    ): Observable<BaseRequest<LoginAndRegisterBean>> {
        return MainRetrofit().apiService.login(name,password)
    }

    override fun register(
        name: String,
        password: String,
        rePassword: String
    ): Observable<BaseRequest<LoginAndRegisterBean>> {
        return MainRetrofit().apiService.register(name, password, rePassword)
    }

}