package leo.study.kotlin_mvp_demo.ui.mvp.fragment.more_navigation

import io.reactivex.Observable
import leo.study.kotlin_mvp_demo.beans.NaviModel
import leo.study.kotlin_mvp_demo.common.BaseRequest
import leo.study.lib_base.mvp.BaseModel
import leo.study.lib_base.mvp.IModel
import leo.study.lib_base.mvp.IPresenter
import leo.study.lib_base.mvp.IView


/**
 *
 * ***********************************************************************
 *the project desc: 更多-导航页面-契约类
 *this name is NavigationContract
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月13日 16:49:16
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
interface NavigationContract {

    interface View:IView<Presenter>{
        fun getDataSuccess(result:MutableList<NaviModel>)
    }


    interface Presenter:IPresenter<View,Model>{
        fun getData()
    }

    interface Model : IModel{
        fun getData():Observable<BaseRequest<MutableList<NaviModel>>>
    }
}