package leo.study.kotlin_mvp_demo.ui.mvp.fragment.more_system

import io.reactivex.Observable
import leo.study.kotlin_mvp_demo.beans.SystemBean
import leo.study.kotlin_mvp_demo.common.BaseRequest
import leo.study.lib_base.mvp.IModel
import leo.study.lib_base.mvp.IPresenter
import leo.study.lib_base.mvp.IView


/**
 *
 * ***********************************************************************
 *the project desc: 更多-体系页面 契约类
 *this name is SystemConstract
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月14日 16:46:58
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
interface SystemContract {

    interface View:IView<Presenter>{
        fun getSystemSuccess(result:MutableList<SystemBean>)
    }


    interface Presenter:IPresenter<View,Model>{
        fun getSystemData()

    }


    interface Model:IModel{
        fun getSystemData():Observable<BaseRequest<MutableList<SystemBean>>>
    }
}