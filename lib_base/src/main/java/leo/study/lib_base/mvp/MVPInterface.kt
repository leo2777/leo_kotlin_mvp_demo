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

    /**
     * 获取上下文
     *
     * @return context
     */
    fun getCtx(): Context?

    /**
     * 初始化完毕，
     * 用户绑定Presenter
     */
    fun initEnd();

    /**
     * 结束当前页面
     *
     * @param resultCode 返回结果代码
     */
    fun finish(resultCode: Int = Activity.RESULT_CANCELED)

    /**
     * 显示加载框
     *
     * @param isTimer 是否自动消失，true:显示一定时间消失，false:一直显示
     */
    fun showLoading(isTimer: Boolean)

    /**
     * 显示自定义文字加载框
     *
     * @param msg 显示文字
     * @param isTimer 是否自动消失，true:显示一定时间消失，false:一直显示
     */
    fun showLoading(msg: String,isTimer: Boolean)

    /**
     * 显示自定义文字加载框（资源文件）
     *
     * @param msgId 资源文件ID
     * @param isTimer 是否自动消失，true:显示一定时间消失，false:一直显示
     */
    fun showLoading(@StringRes msgId: Int,isTimer: Boolean)

    /**
     * 关闭加载框
     */
    fun dismissLoading()

    /**
     * 显示吐司
     *
     * @param message 显示文字
     */
    fun showToast(message: String)

    /**
     * 显示吐司 （资源文件ID）
     *
     * @param messageId 资源文件id
     */
    fun showToast(@StringRes messageId: Int)
}

/**
 * P层，顶级基础方法
 */
interface ITopPresenter : LifecycleObserver {
    /**
     * 关联 view
     *
     * @param view
     */
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
    var model: M?
    var view: V?

    fun getContext() = view?.getCtx()

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





