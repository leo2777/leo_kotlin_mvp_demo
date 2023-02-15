package leo.study.kotlin_mvp_demo.beans

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


/**
 *
 * ***********************************************************************
 *the project desc: 文章列表 数据实体，项目中多次引用，故抽离出来
 *this name is ArticleDataRepo
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月07日 11:04:52
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */


/**
 *  //文章分类数据实体 （公众号，项目 页面用到）
 *  项目中多次用到，故提取
 *
 * @property articleList
 * @property author
 * @property children
 * @property courseId
 * @property cover
 * @property desc
 * @property id
 * @property lisense
 * @property lisenseLink
 * @property name
 * @property order
 * @property parentChapterId
 * @property type
 * @property userControlSetTop
 * @property visible
 */
data class ArticleCategory(
    @SerializedName("articleList")
    val articleList: List<Any>,
    @SerializedName("author")
    val author: String,
    @SerializedName("children")
    val children: List<Any>,
    @SerializedName("courseId")
    val courseId: Int,
    @SerializedName("cover")
    val cover: String,
    @SerializedName("desc")
    val desc: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lisense")
    val lisense: String,
    @SerializedName("lisenseLink")
    val lisenseLink: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("order")
    val order: Int,
    @SerializedName("parentChapterId")
    val parentChapterId: Int,
    @SerializedName("type")
    val type: Int,
    @SerializedName("userControlSetTop")
    val userControlSetTop: Boolean,
    @SerializedName("visible")
    val visible: Int
)


/**
 * 文章标志
 *
 * @property [name] 名字
 * @property [url] 链接
 */
@Parcelize
data class ArticleTag(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String,
) : Parcelable

/**
 * 文章列表实体（分页）
 *
 * @property [curPage] 当前页面页数
 * @property [offset] 偏移页面（当前页面之前还有多少数据）
 * @property [over]  是否加载完毕  false 没有，true 加载完毕所有数据
 * @property [pageCount] 页面总数
 * @property [size] 一页的数据大小
 * @property [total] 文章总数
 * @property [articles] 当前页面数据
 */
data class ArticlePage(
    @SerializedName("curPage") val curPage: Int,
    @SerializedName("offset") val offset: Int,
    @SerializedName("over") val over: Boolean,
    @SerializedName("pageCount") val pageCount: Int,
    @SerializedName("size") val size: Int,
    @SerializedName("total") val total: Int,
    @SerializedName("datas") val articles: MutableList<Articles>,
)

/**
 * 文章单个数据集合
 *
 * @property adminAdd 是否官方文章
 * @property apkLink apk链接
 * @property audit
 * @property author 作者名
 * @property canEdit 是否可以编辑
 * @property chapterId 分类ID
 * @property chapterName 分类名字
 * @property collect 是否收藏
 * @property courseId --
 * @property desc 详情
 * @property descMd --
 * @property envelopePic 项目图片地址
 * @property fresh 是否最新
 * @property host --
 * @property id ID
 * @property isAdminAdd 是否管理员添加
 * @property link 链接（webView）
 * @property niceDate 更新时间
 * @property niceShareDate 更新时间
 * @property origin --
 * @property prefix --
 * @property projectLink 项目链接
 * @property publishTime push时间
 * @property realSuperChapterId --
 * @property selfVisible 自己可见
 * @property shareDate 分享时间
 * @property shareUser 分享用户
 * @property superChapterId --
 * @property superChapterName 父类 名称
 * @property tags 标签
 * @property title 文章标题
 * @property type 类型
 * @property userId 用户ID
 * @property visible 是否显示
 * @property zan 点赞
 * @property top 是否置顶  「1」 置顶,「0」普通  默认是「0」
 */
@Parcelize
data class Articles(
    //单个文章数据实体
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
) : Parcelable