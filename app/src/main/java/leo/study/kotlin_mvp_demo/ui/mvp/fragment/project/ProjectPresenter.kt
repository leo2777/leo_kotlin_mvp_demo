package leo.study.kotlin_mvp_demo.ui.mvp.fragment.project

import leo.study.kotlin_mvp_demo.net.leoSubscribe
import leo.study.lib_base.mvp.BasePresenter


/**
 *
 * ***********************************************************************
 *the project desc: 项目页面P层
 *this name is ProjectPresenter
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月07日 13:53:51
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class ProjectPresenter() :BasePresenter<ProjectContract.View>(),ProjectContract.Presenter {

    override var model: ProjectContract.Model? = ProjectModel()

    override fun getCategory() {
        model!!.getCategory().leoSubscribe(view, model, true) {
            view!!.getCategorySuccess(it.data)
        }
    }
}