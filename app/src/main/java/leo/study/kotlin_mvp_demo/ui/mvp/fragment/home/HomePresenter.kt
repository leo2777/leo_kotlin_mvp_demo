package leo.study.kotlin_mvp_demo.ui.mvp.fragment.home

import leo.study.kotlin_mvp_demo.net.leoSubscribe
import leo.study.lib_base.mvp.BasePresenter


/**
 *
 * ***********************************************************************
 *the project desc: 主页 fragment presenter
 *this name is HomePresenter
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年01月31日 10:52:58
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class HomePresenter : BasePresenter<HomeContact.View>(),HomeContact.Presenter {



    override fun getBanner() {
        model?.getBanner()?.leoSubscribe(view,model){
            view?.getBannerSuccess(it.data)
        }
    }

    override var model: HomeContact.Model? = HomeModel()
}