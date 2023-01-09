package leo.study.lib_base.mvp

import io.reactivex.disposables.CompositeDisposable


/**
 *
 * ***********************************************************************
 *the project desc: M层
 *this name is BaseModel
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2022年11月08日 14:27:29
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
open class BaseModel {
    val disposablePool: CompositeDisposable by lazy { CompositeDisposable() }
}