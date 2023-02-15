package leo.study.kotlin_mvp_demo.ui.mvp.fragment.more_system

import leo.study.kotlin_mvp_demo.net.leoSubscribe
import leo.study.lib_base.mvp.BasePresenter


/**
 *
 * ***********************************************************************
 *the project desc: 更多- 体系页面 - P层
 *this name is SystemPresenter
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月14日 16:53:53
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class SystemPresenter : BasePresenter<SystemContract.View>(), SystemContract.Presenter {
    override fun getSystemData() {
        model?.getSystemData()?.leoSubscribe(view,model,true) {
            view?.getSystemSuccess(it.data)
        }
    }

    override var model: SystemContract.Model? = SystemModel()
}