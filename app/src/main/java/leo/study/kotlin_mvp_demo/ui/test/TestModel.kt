package leo.study.kotlin_mvp_demo.ui.test

import android.os.Build.VERSION_CODES.O
import android.os.Looper
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import kotlinx.coroutines.flow.callbackFlow
import leo.study.lib_base.mvp.BaseModel
import leo.study.lib_base.scheduler.SchedulerUtils
import java.util.concurrent.TimeUnit
import java.util.logging.Handler
import leo.study.kotlin_mvp_demo.ui.test.TestBean as TestBean


/**
 *
 * ***********************************************************************
 *the project desc: 测试kotlin model
 *this name is TestModel
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2022年12月28日 10:32:47
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class TestModel : BaseModel(), TestContract.Model {

    override fun getData(): Observable<TestBean> {
        return Observable.create<TestBean> {

            //测试加载弹窗时间 三秒
            Thread(Runnable {
                Thread.sleep(3000)
                it.onNext(TestBean("测试是否成功"))
                it.onComplete()
            }).start()
        }
    }


}