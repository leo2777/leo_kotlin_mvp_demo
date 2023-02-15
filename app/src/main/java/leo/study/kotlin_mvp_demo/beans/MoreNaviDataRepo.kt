package leo.study.kotlin_mvp_demo.beans

import com.google.gson.annotations.SerializedName


/**
 *
 * ***********************************************************************
 *the project desc: 更多页面-导航页面-请求数据结果实体类
 *this name is MoreNaviDataRepo
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月13日 11:18:45
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */

data class NaviModel(
    @SerializedName("cid") val cid:Int,
    @SerializedName("name") val name:String,
    @SerializedName("articles") val articles: ArrayList<Articles>,
    var isSelect:Boolean = false,
    var oldSelectPosition:Int = -1,
)