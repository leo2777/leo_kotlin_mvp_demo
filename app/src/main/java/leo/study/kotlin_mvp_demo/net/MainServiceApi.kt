package leo.study.kotlin_mvp_demo.net

import io.reactivex.Observable
import leo.study.kotlin_mvp_demo.beans.ArticlePage
import leo.study.kotlin_mvp_demo.beans.Articles
import leo.study.kotlin_mvp_demo.beans.BannerModel
import leo.study.kotlin_mvp_demo.common.BaseRequest
import retrofit2.http.GET
import retrofit2.http.Path


/**
 *
 * ***********************************************************************
 *the project desc: 主 接口service 类，用于retrofit
 *this name is MainService
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年01月13日 15:59:58
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
interface MainServiceApi {


    /**
     * 首页
     */

    /**
     * 获取首页banner接口
     *
     * @return
     */
    @GET("banner/json")
    fun getBanner():Observable<BaseRequest<MutableList<BannerModel>>>

    /**
     * 获取 文章列表
     *
     * @param pageNum 页数 0开始
     * @return
     */
    @GET("article/list/{pageNum}/json")
    fun getArticles(@Path("pageNum") pageNum:Int):Observable<BaseRequest<ArticlePage>>


    /**
     * 获取 置顶文章列表
     *
     * @return
     */
    @GET("article/top/json")
    fun getTopArticles():Observable<BaseRequest<MutableList<Articles>>>

}