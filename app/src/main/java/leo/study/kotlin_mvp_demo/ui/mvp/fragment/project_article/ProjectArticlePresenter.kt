package leo.study.kotlin_mvp_demo.ui.mvp.fragment.project_article

import leo.study.kotlin_mvp_demo.net.leoSubscribe
import leo.study.lib_base.mvp.BasePresenter


/**
 *
 * ***********************************************************************
 *the project desc: 项目- 项目列表 P层
 *this name is ProjectArticlePresenter
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月07日 17:37:18
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class ProjectArticlePresenter:BasePresenter<ProjectArticleContract.View>(),ProjectArticleContract.Presenter{


    override fun getArticles(page: Int, id: String) {
        model?.getArticles(page,id)?.leoSubscribe (view,model) {
            view?.getArticleSuccess(it.data)
        }
    }

    override var model: ProjectArticleContract.Model? = ProjectArticleModel()

}