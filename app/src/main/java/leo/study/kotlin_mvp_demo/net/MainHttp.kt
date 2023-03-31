package leo.study.kotlin_mvp_demo.net

import com.google.gson.JsonParseException
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import leo.study.kotlin_mvp_demo.common.BaseRequest
import leo.study.kotlin_mvp_demo.constants.Constants
import leo.study.kotlin_mvp_demo.ui.mvp.activity.login_or_register.LoginOrRegisterActivity
import leo.study.lib_base.ext.*
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
    isShowLoad: Boolean = false,
    msg: String = "",
    onSuccess: (T) -> Unit
) {
    this.compose(SchedulerUtils.ioToMain())
        .subscribe(object : Observer<T> {
            override fun onSubscribe(d: Disposable) {
                iModel?.disposablePool?.add(d)
                if (isShowLoad) iBaseView?.showLoading((msg.ifEmpty { "请求中···" }), false)
            }

            override fun onNext(t: T) {
                val bean = t as BaseRequest<*>
                when (bean.errorCode) {
                    CodeStatus.SUCCESS_CODE -> {
                        showLogD("请求成功，数据返回：$bean")
                        onSuccess.invoke(t)
                    }
                    CodeStatus.NO_LOGIN_CODE -> {
                        MainScope().launch {
                            iBaseView?.getCtx()?.dataStorePut(Constants.IS_LOGIN,false)
                        }
                        iBaseView?.getCtx()?.startActivity<LoginOrRegisterActivity>()
//                        iBaseView?.getCtx()?.startActivity(Intent(iBaseView.getCtx(),LoginOrRegisterActivity::class.java))
                    }
                    else -> {
                        if (bean.errorMsg.isEmpty()) {
                            showLogE("请求成功，返回数据错误！")
                            iBaseView?.getCtx()?.showError("请求成功，返回数据错误！")
                            return
                        }
                        showLogE(bean.errorMsg)
                        iBaseView?.getCtx()?.showError(bean.errorMsg)
                    }

                }
            }

            override fun onError(e: Throwable) {
                iBaseView?.dismissLoading()

                when (e) {
                    is SocketTimeoutException, is ConnectException, is UnknownHostException -> {
                        showLogE("连接失败，请检查网络状况")
                        iBaseView?.getCtx()?.showError("连接失败，请检查网络状况")
                    }
                    is JsonParseException -> {
                        showLogE("请求成功，数据解析失败！")
                        iBaseView?.getCtx()?.showError("请求成功，数据解析失败！")
                    }
                    else -> {
                        showLogE("未知错误！")
                        iBaseView?.getCtx()?.showError("未知错误！")
                    }
                }

            }

            override fun onComplete() {
                iBaseView?.dismissLoading()
            }
        })
}


/**
 * 不请求网络的 线程调度
 *
 * @param T           返回数据实体
 * @param iBaseView   绑定的view 不能省略
 * @param isShowLoad  是否显示加载框
 * @param msg         加载框显示信息
 * @param onSuccess   成功返回接口
 */
fun <T : Any> Observable<T>.resultSubscribe(
    iBaseView: ITopView,
    isShowLoad: Boolean = false,
    msg: String = "",
    onSuccess: (T) -> Unit
) {
    this.compose(SchedulerUtils.ioToMain())
        .subscribe(object : Observer<T> {
            override fun onSubscribe(d: Disposable) {
                if (isShowLoad) iBaseView.showLoading((msg.ifEmpty { "请求中···" }), false)
            }

            override fun onNext(t: T) {
                onSuccess.invoke(t)
            }

            override fun onError(e: Throwable) {
                iBaseView.getCtx()?.showError(e.message.toString())
            }

            override fun onComplete() {
                iBaseView.dismissLoading()
            }
        })
}

