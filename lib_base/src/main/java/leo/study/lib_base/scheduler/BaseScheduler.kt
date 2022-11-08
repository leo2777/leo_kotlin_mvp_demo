package leo.study.lib_base.scheduler

import io.reactivex.*
import org.reactivestreams.Publisher


/**
 *
 * ***********************************************************************
 *the project desc: rcJava 任务调度基础类
 *this name is BaseScheduler
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2022年10月31日 14:47:48
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
abstract class BaseScheduler<T> protected constructor(
    private val subscribeOnScheduler: Scheduler,
    private val observeOnScheduler: Scheduler
) : ObservableTransformer<T, T>,
    SingleTransformer<T, T>,
    MaybeTransformer<T, T>,
    CompletableTransformer,
    FlowableTransformer<T, T> {


    override fun apply(upstream: Completable): CompletableSource {
        return upstream.retry(2).subscribeOn(subscribeOnScheduler)
            .observeOn(observeOnScheduler)
    }

    override fun apply(upstream: Flowable<T>): Publisher<T> {
        return upstream.retry(2).subscribeOn(subscribeOnScheduler)
            .observeOn(observeOnScheduler)
    }

    override fun apply(upstream: Maybe<T>): MaybeSource<T> {
        return upstream.retry(2).subscribeOn(subscribeOnScheduler)
            .observeOn(observeOnScheduler)
    }

    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream.retry(2).subscribeOn(subscribeOnScheduler)
            .observeOn(observeOnScheduler)
    }

    override fun apply(upstream: Single<T>): SingleSource<T> {
        return upstream.retry(2).subscribeOn(subscribeOnScheduler)
            .observeOn(observeOnScheduler)
    }
}