package leo.study.kotlin_mvp_demo.ui.mvp.fragment.project

import io.reactivex.Observable
import leo.study.kotlin_mvp_demo.beans.ProjectCategory
import leo.study.kotlin_mvp_demo.common.BaseRequest
import leo.study.kotlin_mvp_demo.net.MainRetrofit
import leo.study.lib_base.mvp.BaseModel


/**
 *
 * ***********************************************************************
 *the project desc: 项目页面-model
 *this name is ProjectModel
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月07日 11:36:25
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class ProjectModel:BaseModel(),ProjectContract.Model {

    override fun getCategory(): Observable<BaseRequest<MutableList<ProjectCategory>>>{
        return MainRetrofit().apiService.getProjectCateGory()
    }
}