package leo.study.kotlin_mvp_demo.ui.mvp.fragment.home

import io.reactivex.Observable
import leo.study.kotlin_mvp_demo.common.BaseRequest
import leo.study.kotlin_mvp_demo.model.home.BannerModel
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
class HomeModel :BaseModel(),HomeContact.Model {
    override fun getBanner(): Observable<BaseRequest<List<BannerModel>>> {
        return MainRetrofit().getService().getBanner()
    }


}