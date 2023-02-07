package leo.study.kotlin_mvp_demo.ui.mvp.fragment.project_article

import io.reactivex.Observable
import leo.study.kotlin_mvp_demo.beans.ArticlePage
import leo.study.kotlin_mvp_demo.common.BaseRequest
import leo.study.kotlin_mvp_demo.net.MainRetrofit
import leo.study.lib_base.mvp.BaseModel


/**
 *
 * ***********************************************************************
 *the project desc: 项目 子页面 - 项目列表
 *this name is ProjectArticleModel
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月07日 17:26:10
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class ProjectArticleModel:BaseModel(),ProjectArticleContract.Model {

    override fun getArticles(page: Int,id:String): Observable<BaseRequest<ArticlePage>> {
        return MainRetrofit().apiService.getProjectArticles(page,id)
    }
}