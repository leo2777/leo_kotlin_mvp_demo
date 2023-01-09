package leo.study.lib_base.mvp

import android.app.Activity
import android.content.Context
import androidx.annotation.StringRes
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.jetbrains.annotations.NotNull
import java.lang.RuntimeException
import java.util.logging.Logger


/**
 *
 * ***********************************************************************
 *the project desc: M层，V层，P层 基础接口类
 *this name is MVPInterface
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2022年11月08日 10:49:47
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */

/**
 * V 层 顶级基础方法
 */
interface ITopView : LifecycleOwner {

    fun getContext(): Context?
    fun initEnd();
    fun finish(resultCode: Int = Activity.RESULT_CANCELED)
    fun showLoading(isTimer: Boolean)
    fun showLoading(msg: String,isTimer: Boolean)
    fun showLoading(@StringRes msgId: Int,isTimer: Boolean)
    fun dismissLoading()
    fun showToast(@NotNull message: String)
    fun showToast(@StringRes messageId: Int)
}

/**
 * P层，顶级基础方法
 */
interface ITopPresenter : LifecycleObserver {
    fun attachView(view: ITopView)

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun detachView()
}

/**
 * M层，顶级基础方法
 */
interface ITopModel {
    fun onDetach();
}


/**
 * V层，基础（绑定P层）
 */
interface IView<P : ITopPresenter> : ITopView {
    var presenter: P

    //绑定V
    override fun initEnd() {
        presenter.attachView(this)
    }
}

/**
 * P层 基础 M,V 逻辑操作
 */
interface IPresenter<V : ITopView, M : ITopModel> : ITopPresenter {
    var view: V?
    var model: M?

    fun getContext() = view?.getContext()

    @Suppress("UNCHECKED_CAST")
    override fun attachView(view: ITopView) {
        this.view = view as V
        this.view?.lifecycle?.addObserver(this)
    }

    override fun detachView() {
        model?.onDetach()
        model = null
        view = null
    }

    /**
     * 判断是否初始化View 不为空才初始化)
     */
    private val isViewAttached: Boolean
        get() = view != null


    fun checkViewAttached(){
        if (!isViewAttached) throw MvpViewNotAttachedException()
    }


    private class MvpViewNotAttachedException internal constructor() : RuntimeException("Please call IPresenter.attachView(IBaseView) before" + " requesting data to the IPresenter")

}


interface IModel : ITopModel{
    val disposablePool : CompositeDisposable

    fun addDisposable(disposable:Disposable){
        disposablePool.add(disposable)
    }

    override fun onDetach() {
        if (!disposablePool.isDisposed){
            disposablePool.clear()
        }
    }
}





