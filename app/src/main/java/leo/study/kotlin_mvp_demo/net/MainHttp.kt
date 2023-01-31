package leo.study.kotlin_mvp_demo.net

import android.widget.Toast
import com.google.gson.JsonParseException
import com.orhanobut.logger.Logger
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import leo.study.kotlin_mvp_demo.common.BaseRequest
import leo.study.kotlin_mvp_demo.utils.ToastyUtils
import leo.study.lib_base.http.constant.CodeStatus
import leo.study.lib_base.mvp.IModel
import leo.study.lib_base.mvp.ITopView
import leo.study.lib_base.scheduler.SchedulerUtils
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException


/**
 *
 * ***********************************************************************
 *the project desc: 主  api 请求线程调度类 （返回实体基础操作  如：登陆超时等等）
 *this name is MainHttp
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年01月13日 16:21:29
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */


fun <T : Any> Observable<T>.leoSubscribe(
    iBaseView: ITopView? = null,
    iModel: IModel? = null,
    msg: String = "",
    onSuccess: (T) -> Unit
) {
    this.compose(SchedulerUtils.ioToMain())
        .subscribe(object : Observer<T>{
            override fun onSubscribe(d: Disposable) {
                iModel?.disposablePool?.add(d)
                iBaseView?.showLoading((msg.ifEmpty { "请求中···" }),false)
            }
            override fun onNext(t: T) {
                val bean = t as BaseRequest<*>
                Logger.e(bean.toString())
                when(bean.errorCode){
                    CodeStatus.SUCCESS_CODE -> {
                        onSuccess.invoke(t)
                    }
                    CodeStatus.FAIL_CODE ->{
                        if (bean.errorMsg.isEmpty()){
                            ToastyUtils.showError("请求成功，返回数据错误！")
                            return
                        }
                        ToastyUtils.showError(bean.errorMsg)
                    }

                }
            }
            override fun onError(e: Throwable) {
                iBaseView?.dismissLoading()

                when (e) {
                    is SocketTimeoutException, is ConnectException, is UnknownHostException -> {
                        ToastyUtils.showError("连接失败，请检查网络状况")
                    }
                    is JsonParseException -> {
                        ToastyUtils.showError("请求成功，数据解析失败！")
                    }
                    else -> {
                        ToastyUtils.showError("未知错误！")
                    }
                }

            }
            override fun onComplete() {
                iBaseView?.dismissLoading()
            }
        })
}

