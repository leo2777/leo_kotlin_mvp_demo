package leo.study.kotlin_mvp_demo.ui.mvp.fragment.wechat

import leo.study.kotlin_mvp_demo.net.leoSubscribe
import leo.study.lib_base.mvp.BasePresenter


/**
 *
 * ***********************************************************************
 *the project desc: 公众号- P层
 *this name is WeChatPresenter
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月08日 11:38:07
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class WeChatPresenter:BasePresenter<WeChatContract.View>(),WeChatContract.Presenter {

    override var model: WeChatContract.Model? = WeChatModel()

    override fun getCategory() {
        model?.getCategory()?.leoSubscribe(view,model,true) {
            view?.getCategorySuccess(it.data)
        }
    }

}