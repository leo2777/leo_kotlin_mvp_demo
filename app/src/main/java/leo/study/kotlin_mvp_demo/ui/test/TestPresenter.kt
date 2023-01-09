package leo.study.kotlin_mvp_demo.ui.test

import android.annotation.SuppressLint
import android.util.Log.e
import com.google.gson.JsonParseException
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import leo.study.lib_base.http.constant.CodeStatus
import leo.study.lib_base.mvp.BasePresenter
import leo.study.lib_base.scheduler.SchedulerUtils
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.logging.Logger


/**
 *
 * ***********************************************************************
 *the project desc: 测试 kotlin P
 *this name is TestPresenter
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2022年12月28日 10:34:19
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class TestPresenter: BasePresenter<TestContract.View>(),TestContract.Presenter {
    @SuppressLint("CheckResult")
    override fun getData() {
        model?.getData()
            ?.compose(SchedulerUtils.ioToMain())
            ?.subscribe(object : Observer<TestBean> {
                override fun onComplete() {
                    view?.dismissLoading()
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: TestBean) {
                    view?.getDataSuccess(t.name)
                }

                override fun onError(e: Throwable) {
                    view?.dismissLoading()
                }
            })
    }

    override var model: TestContract.Model ?= TestModel()
}