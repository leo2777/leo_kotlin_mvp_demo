package leo.study.kotlin_mvp_demo.beans


import com.google.gson.annotations.SerializedName

data class UserInfoBean(
    @SerializedName("coinInfo")
    val coinInfo: CoinInfo,
    @SerializedName("collectArticleInfo")
    val collectArticleInfo: CollectArticleInfo,
    @SerializedName("userInfo")
    val userInfo: UserInfo
)

data class CoinInfo(
    @SerializedName("coinCount")
    val coinCount: Int,
    @SerializedName("level")
    val level: Int,
    @SerializedName("nickname")
    val nickname: String,
    @SerializedName("rank")
    val rank: String,
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("username")
    val username: String
)

data class CollectArticleInfo(
    @SerializedName("count")
    val count: Int
)

data class UserInfo(
    @SerializedName("admin")
    val admin: Boolean,
    @SerializedName("chapterTops")
    val chapterTops: List<Any>,
    @SerializedName("coinCount")
    val coinCount: Int,
    @SerializedName("collectIds")
    val collectIds: List<Any>,
    @SerializedName("email")
    val email: String,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("nickname")
    val nickname: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("publicName")
    val publicName: String,
    @SerializedName("token")
    val token: String,
    @SerializedName("type")
    val type: Int,
    @SerializedName("username")
    val username: String
)