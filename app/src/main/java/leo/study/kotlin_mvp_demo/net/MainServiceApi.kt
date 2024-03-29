package leo.study.kotlin_mvp_demo.net

import io.reactivex.Observable
import leo.study.kotlin_mvp_demo.beans.*
import leo.study.kotlin_mvp_demo.common.BaseRequest
import retrofit2.http.*


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

//==================================================================================================

    /**
     * 首页
     */

    /**
     * 获取首页banner接口
     *
     * @return
     */
    @GET("banner/json")
    fun getBanner(): Observable<BaseRequest<MutableList<BannerModel>>>

    /**
     * 获取 文章列表
     *
     * @param pageNum 页数 0开始
     * @return
     */
    @GET("article/list/{pageNum}/json")
    fun getArticles(@Path("pageNum") pageNum: Int): Observable<BaseRequest<ArticlePage>>


    /**
     * 获取 置顶文章列表
     *
     * @return
     */
    @GET("article/top/json")
    fun getTopArticles(): Observable<BaseRequest<MutableList<Articles>>>


//==================================================================================================


    /**
     * 项目页面
     */

    /**
     * 获取分类列表
     *
     * @return 数据实体
     */
    @GET("project/tree/json")
    fun getProjectCateGory(): Observable<BaseRequest<MutableList<ArticleCategory>>>


    /**
     * 获取分类下文章列表
     *
     * @param [page] 页数
     * @param [id] 分类id
     * @return 数据实体
     */
    @GET("project/list/{page}/json")
    fun getProjectArticles(
        @Path("page") page: Int,
        @Query("cid") id: String
    ): Observable<BaseRequest<ArticlePage>>


//==================================================================================================


    /**
     * 获取公众号分类数据（作者）
     *
     * @return 数据实体
     */
    @GET("wxarticle/chapters/json")
    fun getWeChatCategory(): Observable<BaseRequest<MutableList<ArticleCategory>>>


    /**
     * 获取当前分类下公众号
     *
     * @param [authorId] 作者ID
     * @param [page] 页数
     * @return 数据实体
     */
    @GET("wxarticle/list/{authorId}/{page}/json")
    fun getWeChatArticle(
        @Path("authorId") authorId: String,
        @Path("page") page: Int
    ): Observable<BaseRequest<ArticlePage>>


//==================================================================================================


    /**
     * 更多页面-广场子页面-获取广场文章数据
     *
     * @param page 页码
     * @return 数据实体
     */
    @GET("user_article/list/{page}/json")
    fun getSquareArticles(@Path("page") page: Int): Observable<BaseRequest<ArticlePage>>


    /**
     * 更多页面-导航子页面-获取导航数据
     *
     * @return 数据实体
     */
    @GET("navi/json")
    fun getNaviData(): Observable<BaseRequest<MutableList<NaviModel>>>


    /**
     * 更多页面-体系子页面-获取体系数据
     *
     * @return 数据实体
     */
    @GET("tree/json")
    fun getSystemData(): Observable<BaseRequest<MutableList<SystemBean>>>


    //==============================================================================================


    /**
     * 登录接口
     *
     * @param name 名字
     * @param password 密码
     * @return
     */
    @POST("user/login")
    @FormUrlEncoded
    fun login(
        @Field("username") name: String,
        @Field("password") password: String
    ): Observable<BaseRequest<LoginAndRegisterBean>>


    /**
     * 注册
     *
     * @param name 名字
     * @param password 密码
     * @param rePassword 确定密码
     * @return
     */
    @POST("user/register")
    @FormUrlEncoded
    fun register(
        @Field("username") name: String,
        @Field("password") password: String,
        @Field("repassword") rePassword: String
    ): Observable<BaseRequest<LoginAndRegisterBean>>





//==================================================================================================

    /**
     * 获取个人信息
     *
     * @return
     */
    @GET("user/lg/userinfo/json")
    fun getUserInfo():Observable<BaseRequest<UserInfoBean>>




//==================================================================================================

    //收藏相关

    /**
     * 收藏文章
     *
     * @param id 文章ID
     * @return
     */
    @POST("lg/collect/{id}/json")
    fun collectArticle(@Path("id") id:String):Observable<BaseRequest<Any>>


    /**
     * 取消收藏文章
     *
     * @param id 文章ID
     * @return
     */
    @POST("lg/uncollect_originId/{id}/json")
    fun cancelCollectArticle(@Path("id") id:String):Observable<BaseRequest<Any>>


    /**
     * 获取我的收藏列表
     *
     * @param page 页数
     * @return
     */
    @GET("lg/collect/list/{page}/json")
    fun getMyCollectList(@Path("page") page:Int):Observable<BaseRequest<ArticlePage>>



}