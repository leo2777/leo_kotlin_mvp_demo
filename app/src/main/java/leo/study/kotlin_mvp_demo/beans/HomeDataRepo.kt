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

data class BannerModel(
//首页 banner 数据实体
    @SerializedName("desc") val desc: String, //详情
    @SerializedName("id") val id: Int,  //ID
    @SerializedName("imagePath") val imagePath: String, //图片地址
    @SerializedName("isVisible") val isVisible: Int, //是否显示
    @SerializedName("order") val order: Int,
    @SerializedName("title") val title: String, //标题
    @SerializedName("type") val type: Int,
    @SerializedName("url") val url: String, //url
)



