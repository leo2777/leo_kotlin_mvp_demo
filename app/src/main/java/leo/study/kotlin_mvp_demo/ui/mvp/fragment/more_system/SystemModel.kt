package leo.study.kotlin_mvp_demo.ui.mvp.fragment.more_system

import io.reactivex.Observable
import leo.study.kotlin_mvp_demo.beans.SystemBean
import leo.study.kotlin_mvp_demo.common.BaseRequest
import leo.study.kotlin_mvp_demo.net.MainRetrofit
import leo.study.lib_base.mvp.BaseModel


/**
 *
 * ***********************************************************************
 *the project desc: 更多- 体系页面——M层
 *this name is SystemModel
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月14日 16:52:35
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class SystemModel:BaseModel(),SystemContract.Model {
    override fun getSystemData(): Observable<BaseRequest<MutableList<SystemBean>>> {
        return MainRetrofit().apiService.getSystemData()
    }
}