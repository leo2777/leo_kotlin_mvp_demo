package leo.study.kotlin_mvp_demo.ui.mvp.fragment.more_navigation

import io.reactivex.Observable
import leo.study.kotlin_mvp_demo.beans.NaviModel
import leo.study.kotlin_mvp_demo.common.BaseRequest
import leo.study.kotlin_mvp_demo.net.MainRetrofit
import leo.study.lib_base.mvp.BaseModel


/**
 *
 * ***********************************************************************
 *the project desc: 更多-导航页面- M层
 *this name is NavigationModel
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月13日 16:54:12
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class NavigationModel:BaseModel(),NavigationContract.Model {

    override fun getData(): Observable<BaseRequest<MutableList<NaviModel>>> {
        return MainRetrofit().apiService.getNaviData()
    }
}