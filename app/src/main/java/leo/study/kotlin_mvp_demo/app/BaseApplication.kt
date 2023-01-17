package leo.study.kotlin_mvp_demo.app

import android.app.Application
import android.content.Context
import android.view.Gravity
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import es.dmoral.toasty.Toasty
import leo.study.kotlin_mvp_demo.common.LoggerAdapter


/**
 *
 * ***********************************************************************
 *the project desc: 基础 application
 *this name is BaseApplication
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年01月16日 09:48:24
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class BaseApplication : Application() {

    private val tag: String = "leo_kotlin_mvp_demo"

    companion object {
        var context:BaseApplication? = null
        /**
         * 返回项目的 context
         *
         * @return context
         */
        fun getAppContext(): Context {
            return context!!
        }
    }



    override fun onCreate() {
        super.onCreate()

        context = this;

        init()
    }



    /**
     * 初始化
     *
     */
    private fun init() {
        //初始化logger
        initLogger()
        //初始化toasty
        initToasty()


    }


    /**
     * 初始化 logger 日志
     *
     * 其他具体使用请查看：[logger GitHub网址](https://github.com/orhanobut/logger)
     */
    private fun initLogger() {
        val formatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(false) //（可选）是否显示线程信息。 默认值为true
            .methodCount(2)        //（可选）要显示的方法行数。 默认2
            .methodOffset(0)       //（可选）设置调用堆栈的函数偏移值，0的话则从打印该Log的函数开始输出堆栈信息，默认是0
            .tag(tag)                  //（可选）每个日志的全局标记。 默认PRETTY_LOGGER（如上图）
            .build()
        Logger.addLogAdapter(LoggerAdapter(formatStrategy))
    }

    /**
     * 初始化 颜色 toast
     *
     * 其他具体使用请查看：[toasty Github网址](https://github.com/GrenderG/Toasty)
     */
    private fun initToasty() {
        Toasty.Config.getInstance()
//            .tintIcon(boolean tintIcon) // optional (apply textColor also to the icon)
//            .setToastTypeface(@NonNull Typeface typeface) // optional
            .setTextSize(14) // optional
//            .allowQueue(boolean allowQueue) // optional (prevents several Toastys from queuing)
            .setGravity(Gravity.CENTER) // optional (set toast gravity, offsets are optional)
//            .supportDarkTheme(boolean supportDarkTheme) // optional (whether to support dark theme or not)
//            .setRTL(boolean isRTL) // optional (icon is on the right)
            .apply(); // required
    }




}