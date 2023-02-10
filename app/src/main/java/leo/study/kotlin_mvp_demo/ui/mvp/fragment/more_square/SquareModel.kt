package leo.study.kotlin_mvp_demo.ui.mvp.fragment.more_square

import io.reactivex.Observable
import leo.study.kotlin_mvp_demo.beans.ArticlePage
import leo.study.kotlin_mvp_demo.common.BaseRequest
import leo.study.kotlin_mvp_demo.net.MainRetrofit
import leo.study.lib_base.mvp.BaseModel


/**
 *
 * ***********************************************************************
 *the project desc: 广场页面 M层
 *this name is SquareModel
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月08日 16:53:00
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class SquareModel:BaseModel(),SquareContract.Model{

    override fun getArticles(page: Int): Observable<BaseRequest<ArticlePage>> {
        return MainRetrofit().apiService.getSquareArticles(page)
    }
}