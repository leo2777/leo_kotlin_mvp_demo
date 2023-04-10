package leo.study.kotlin_mvp_demo.ui.mvp.activity.collect

import io.reactivex.Observable
import leo.study.kotlin_mvp_demo.beans.ArticlePage
import leo.study.kotlin_mvp_demo.beans.Articles
import leo.study.kotlin_mvp_demo.common.BaseRequest
import leo.study.kotlin_mvp_demo.net.MainRetrofit
import leo.study.lib_base.mvp.BaseModel


/**
 *
 * ***********************************************************************
 *the project desc: 我的收藏列表 M层
 *this name is Model
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年04月10日 15:08:15
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class Model:BaseModel(),Contract.Model {
    override fun getMyCollectList(page: Int): Observable<BaseRequest<ArticlePage>> {
        return MainRetrofit().apiService.getMyCollectList(page)
    }
}