package leo.study.kotlin_mvp_demo.ui.mvp.fragment.more_square

import leo.study.kotlin_mvp_demo.net.leoSubscribe
import leo.study.lib_base.mvp.BasePresenter


/**
 *
 * ***********************************************************************
 *the project desc: 广场页面 P层
 *this name is SquarePresenter
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月08日 16:54:31
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class SquarePresenter:BasePresenter<SquareContract.View>(),SquareContract.Presenter {


    override var model: SquareContract.Model? = SquareModel()


    override fun refresh() {
        model?.getArticles(0)?.leoSubscribe(view,model) {
            view?.onResult(it.data)
        }
    }

    override fun load(page: Int) {
        model?.getArticles(page)?.leoSubscribe(view,model) {
            view?.onResult(it.data)
        }
    }
}