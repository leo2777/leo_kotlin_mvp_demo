package leo.study.kotlin_mvp_demo.beans

import com.google.gson.annotations.SerializedName


/**
 *
 * ***********************************************************************
 *the project desc: 项目页面，实体数据
 *this name is ProjectDataRepo
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月07日 10:54:59
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */


/**
 * 项目页面数据实体
 */

data class ProjectCategory( //项目列表 数据实体
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
