package leo.study.kotlin_mvp_demo.common

import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import leo.study.kotlin_mvp_demo.BuildConfig


/**
 *
 * ***********************************************************************
 *the project desc: logger  日志适配器
 *this name is LoggerAdapter
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年01月16日 10:27:54
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class LoggerAdapter(formatStrategy: FormatStrategy) : AndroidLogAdapter(formatStrategy) {
    /**
     * 是否开启log日志，true 开启， false 关闭
     * 上线版本的时候需要关闭日志，
     * 采用 [BuildConfig.DEBUG] 来判断
     *
     * @param [priority] 给框架使用，无需理会，只需修改返回值
     * @param [tag] 给框架使用，无需理会，只需修改返回值
     * @return true 开启， false 关闭
     */
    override fun isLoggable(priority: Int, tag: String?): Boolean {
        return BuildConfig.DEBUG;
    }
}