package leo.study.kotlin_mvp_demo.ui.mvp.fragment.home

import io.reactivex.Observable
import leo.study.kotlin_mvp_demo.beans.ArticlePage
import leo.study.kotlin_mvp_demo.beans.Articles
import leo.study.kotlin_mvp_demo.beans.BannerModel
import leo.study.kotlin_mvp_demo.common.BaseRequest
import leo.study.kotlin_mvp_demo.net.MainRetrofit
import leo.study.lib_base.mvp.BaseModel


/**
 *
 * ***********************************************************************
 *the project desc: 主页 fragment
 *this name is HomeModel
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年01月31日 10:49:26
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class HomeModel :BaseModel(),HomeContract.Model {
    override fun getBanner(): Observable<BaseRequest<MutableList<BannerModel>>> {
        return MainRetrofit().apiService.getBanner()
    }

    override fun getArticles(pageNum: Int): Observable<BaseRequest<ArticlePage>> {
        return MainRetrofit().apiService.getArticles(pageNum)
    }

    override fun getTopArticles(): Observable<BaseRequest<MutableList<Articles>>> {
        return MainRetrofit().apiService.getTopArticles()
    }

    override fun collectArticle(id: String): Observable<BaseRequest<Any>> {
        return MainRetrofit().apiService.collectArticle(id)
    }

    override fun cancelCollectArticle(id: String): Observable<BaseRequest<Any>> {
        return MainRetrofit().apiService.cancelCollectArticle(id)
    }


}