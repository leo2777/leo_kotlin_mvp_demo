package leo.study.kotlin_mvp_demo.beans

import android.nfc.Tag
import com.google.gson.annotations.SerializedName


/**
 *
 * ***********************************************************************
 *the project desc: 首页 接口返回数据实体合集
 *this name is BannerModel
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年01月31日 10:10:35
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */

data class BannerModel(//首页 banner 数据实体
    @SerializedName("desc") val desc: String, //详情
    @SerializedName("id") val id: Int,  //ID
    @SerializedName("imagePath") val imagePath: String, //图片地址
    @SerializedName("isVisible") val isVisible: Int, //是否显示
    @SerializedName("order") val order: Int,
    @SerializedName("title") val title: String, //标题
    @SerializedName("type") val type: Int,
    @SerializedName("url") val url: String, //url
)

data class ArticleTag(//文章标志
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String,
)

data class ArticlePage(//文章列表
    @SerializedName("curPage") val curPage:Int,
    @SerializedName("offset") val offset:Int,
    @SerializedName("over") val over:Boolean,
    @SerializedName("pageCount") val pageCount:Int,
    @SerializedName("size") val size:Int,
    @SerializedName("total") val total:Int,
    @SerializedName("datas") val datas:MutableList<Articles>,
)

data class Articles( //单个文章数据实体
    @SerializedName("adminAdd") val adminAdd: Boolean,
    @SerializedName("apkLink") val apkLink: String,
    @SerializedName("audit") val audit: Int,
    @SerializedName("author") val author: String,
    @SerializedName("canEdit") val canEdit: Boolean,
    @SerializedName("chapterId") val chapterId: Int,
    @SerializedName("chapterName") val chapterName: String,
    @SerializedName("collect") val collect: Boolean,
    @SerializedName("courseId") val courseId: Int,
    @SerializedName("desc") val desc: String,
    @SerializedName("descMd") val descMd: String,
    @SerializedName("envelopePic") val envelopePic: String,
    @SerializedName("fresh") val fresh: Boolean,
    @SerializedName("host") val host: String,
    @SerializedName("id") val id: Int,
    @SerializedName("isAdminAdd") val isAdminAdd: Boolean,
    @SerializedName("link") val link: String,
    @SerializedName("niceDate") val niceDate: String,
    @SerializedName("niceShareDate") val niceShareDate: String,
    @SerializedName("origin") val origin: String,
    @SerializedName("prefix") val prefix: String,
    @SerializedName("projectLink") val projectLink: String,
    @SerializedName("publishTime") val publishTime: Long,
    @SerializedName("realSuperChapterId") val realSuperChapterId: Int,
    @SerializedName("selfVisible") val selfVisible: Int,
    @SerializedName("shareDate") val shareDate: Long,
    @SerializedName("shareUser") val shareUser: String,
    @SerializedName("superChapterId") val superChapterId: Int,
    @SerializedName("superChapterName") val superChapterName: String,
    @SerializedName("tags") val tags: List<ArticleTag>,
    @SerializedName("title") val title: String,
    @SerializedName("type") val type: Int,
    @SerializedName("userId") val userId: Int,
    @SerializedName("visible") val visible: Int,
    @SerializedName("zan") val zan: Int,
    @SerializedName("top") var top: String,
)


