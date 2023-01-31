package leo.study.kotlin_mvp_demo.model.home


/**
 *
 * ***********************************************************************
 *the project desc: 首页banner 实体
 *this name is BannerModel
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年01月31日 10:10:35
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
data class BannerModel(
    var desc: String, //详情
    var id: Int,  //ID
    var imagePath: String, //图片地址
    var isVisible: Int, //是否显示
    var order: Int,
    var title: String, //标题
    var type: Int,
    var url: String, //url
)
