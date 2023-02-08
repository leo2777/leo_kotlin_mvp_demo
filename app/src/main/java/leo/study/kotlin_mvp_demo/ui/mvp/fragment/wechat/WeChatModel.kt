package leo.study.kotlin_mvp_demo.ui.mvp.fragment.wechat

import io.reactivex.Observable
import leo.study.kotlin_mvp_demo.beans.ArticleCategory
import leo.study.kotlin_mvp_demo.common.BaseRequest
import leo.study.kotlin_mvp_demo.net.MainRetrofit
import leo.study.kotlin_mvp_demo.net.MainServiceApi
import leo.study.lib_base.mvp.BaseModel


/**
 *
 * ***********************************************************************
 *the project desc: 公众号 M层
 *this name is WeChatModel
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月08日 11:25:01
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class WeChatModel:BaseModel(),WeChatContract.Model {

    override fun getCategory(): Observable<BaseRequest<MutableList<ArticleCategory>>> {
        return MainRetrofit().apiService.getWeChatCategory()
    }
}