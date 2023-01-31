package leo.study.kotlin_mvp_demo.net

import io.reactivex.Observable
import leo.study.kotlin_mvp_demo.common.BaseRequest
import leo.study.kotlin_mvp_demo.model.home.BannerModel
import retrofit2.http.GET
import java.lang.invoke.CallSite


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
    fun getBanner():Observable<BaseRequest<List<BannerModel>>>




}