package leo.study.lib_base.scheduler

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 *
 * ***********************************************************************
 *the project desc: rxJava新线程
 *this name is NewThreadMainScheduler
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2022年10月31日 15:54:30
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class NewThreadMainScheduler<T> private constructor():BaseScheduler<T>(Schedulers.newThread(),AndroidSchedulers.mainThread())