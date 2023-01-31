package leo.study.kotlin_mvp_demo.common


/**
 *
 * ***********************************************************************
 *the project desc: 数据回调实体 基础类
 *this name is BaseRequest
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年01月13日 16:45:14
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */

data class BaseRequest<T>(
    var errorCode: Int,
    var errorMsg: String,
    var data : T
)