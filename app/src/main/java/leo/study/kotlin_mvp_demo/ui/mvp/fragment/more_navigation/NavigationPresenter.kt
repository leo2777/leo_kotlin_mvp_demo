package leo.study.kotlin_mvp_demo.ui.mvp.fragment.more_navigation

import leo.study.kotlin_mvp_demo.net.leoSubscribe
import leo.study.lib_base.mvp.BasePresenter


/**
 *
 * ***********************************************************************
 *the project desc: 更多- 导航页面- P层
 *this name is NavigationPresenter
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月13日 16:56:53
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class NavigationPresenter:BasePresenter<NavigationContract.View>(),NavigationContract.Presenter {
    override fun getData() {
        model?.getData()?.leoSubscribe(view,model,true) {
            view?.getDataSuccess(it.data)
        }
    }

    override var model: NavigationContract.Model ?= NavigationModel()
}