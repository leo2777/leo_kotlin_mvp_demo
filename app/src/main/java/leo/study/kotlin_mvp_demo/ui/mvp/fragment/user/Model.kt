package leo.study.kotlin_mvp_demo.ui.mvp.fragment.user

import android.content.Context
import io.reactivex.Observable
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import leo.study.kotlin_mvp_demo.beans.UserInfoBean
import leo.study.kotlin_mvp_demo.common.BaseRequest
import leo.study.kotlin_mvp_demo.constants.Constants
import leo.study.kotlin_mvp_demo.net.MainRetrofit
import leo.study.lib_base.ext.dataStoreGet
import leo.study.lib_base.ext.showLogE
import leo.study.lib_base.mvp.BaseModel


/**
 *
 * ***********************************************************************
 *the project desc: P层
 *this name is Model
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年03月28日 10:13:47
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class Model : BaseModel(), Contract.Model {

    override fun getIsLogin(context: Context): Observable<Boolean> {
        return Observable.create {
            MainScope().launch {
                it.onNext(context.dataStoreGet(Constants.IS_LOGIN))
                it.onComplete()
            }
        }
    }

    override fun getUserInfo(): Observable<BaseRequest<UserInfoBean>> {
        return MainRetrofit().apiService.getUserInfo()
    }

}
