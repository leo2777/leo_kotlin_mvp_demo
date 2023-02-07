package leo.study.kotlin_mvp_demo.ui.mvp.fragment.project

import io.reactivex.Observable
import leo.study.kotlin_mvp_demo.beans.ProjectCategory
import leo.study.kotlin_mvp_demo.common.BaseRequest
import leo.study.lib_base.mvp.IModel
import leo.study.lib_base.mvp.IPresenter
import leo.study.lib_base.mvp.IView


/**
 *
 * ***********************************************************************
 *the project desc: 项目页面 MVP 契约类
 *this name is ProjectContact
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月07日 11:26:54
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
interface ProjectContract {
    interface View:IView<Presenter>{
        /**
         * 获取数据成功回调
         *
         * @param [result] 结果数据实体（列表）
         */
        fun getCategorySuccess(result:MutableList<ProjectCategory>)
    }

    interface Presenter:IPresenter<View,Model>{
        /**
         * 分类列表数据
         */
        fun getCategory()
    }

    interface Model:IModel{
        /**
         * 获取分类列表
         *
         * @return 数据实体
         */
        fun getCategory(): Observable<BaseRequest<MutableList<ProjectCategory>>>
    }
}