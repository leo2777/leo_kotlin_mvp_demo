package leo.study.kotlin_mvp_demo.ui.mvp.fragment.home

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import leo.study.kotlin_mvp_demo.beans.ArticlePage
import leo.study.kotlin_mvp_demo.beans.Articles
import leo.study.kotlin_mvp_demo.common.BaseRequest
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
class HomePresenter : BasePresenter<HomeContract.View>(), HomeContract.Presenter {

    override var model: HomeContract.Model? = HomeModel()


    /**
     * 获取banner数据
     *
     */
    override fun getBanner() {
        model!!.getBanner().leoSubscribe(view, model, false) {
            view!!.getBannerSuccess(it.data)
        }
    }

    /**
     * 获取页面数据
     *@param [isShowLoading] 是否显示加载框
     */
    override fun getHomeData(isShowLoading:Boolean) {

        //banner
        getBanner()

        //获取 置顶文章 和 文章  合成一个列表数据数组
        val observable = Observable.zip(model!!.getTopArticles(), model!!.getArticles(0),
            BiFunction<BaseRequest<MutableList<Articles>>, BaseRequest<ArticlePage>, BaseRequest<ArticlePage>> { top, all ->
                top.data.forEach {
                    it.top = "1"
                }
                all.data.articles.addAll(0, top.data)
                all
            })

        //完成之后 返回view
        observable.leoSubscribe(view, model, isShowLoading) {
            view!!.getListDataSuccess(it.data)
        }

    }

    override fun getArticles(pageNum: Int) {
        model!!.getArticles(pageNum).leoSubscribe(view, model, false) {
            view!!.getListDataSuccess(it.data)
        }
    }

    override fun collectArticle(id: String,position:Int) {
        model?.collectArticle(id)?.leoSubscribe(view,model) {
            view?.onCollectArticleSuccess(position)
        }
    }

    override fun cancelCollectArticle(id: String,position:Int) {
        model?.cancelCollectArticle(id)?.leoSubscribe(view,model) {
            view?.onCancelCollectArticleSuccess(position)
        }
    }

}