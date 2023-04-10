package leo.study.kotlin_mvp_demo.ui.mvp.activity.collect

import leo.study.kotlin_mvp_demo.net.leoSubscribe
import leo.study.lib_base.mvp.BasePresenter


/**
 *
 * ***********************************************************************
 *the project desc: 我的收藏列表 P层
 *this name is Presenter
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年04月10日 15:09:15
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class Presenter:BasePresenter<Contract.View>(),Contract.Presenter {

    override fun refreshList() {
        model?.getMyCollectList(0)?.leoSubscribe {
            view?.onMyCollectList(it.data)
        }
    }

    override fun loadList(page: Int) {
        model?.getMyCollectList(page)?.leoSubscribe {
            view?.onMyCollectList(it.data)
        }
    }

    override var model: Contract.Model? = Model()
}