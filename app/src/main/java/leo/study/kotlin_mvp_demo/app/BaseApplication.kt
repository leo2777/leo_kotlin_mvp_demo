package leo.study.kotlin_mvp_demo.app

import android.app.Application
import android.content.Context
import android.view.Gravity
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.BezierRadarHeader
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import es.dmoral.toasty.Toasty
import leo.study.kotlin_mvp_demo.R
import leo.study.kotlin_mvp_demo.common.GlideLoaderProcessor
import leo.study.kotlin_mvp_demo.common.LoggerAdapter
import leo.study.lib_base.image.ImageLoaderHelper
import leo.study.lib_base.image.ImageOptions


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
        //初始化 图片加载
        initImage()
        //初始化 智能刷新
        initSmartRefresh()

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


    /**
     * 初始化图片加载代理
     *
     */
    private fun initImage() {
        //设置配置类
        val imageOptions = ImageOptions.Builder(this)
            .placeholderResId(leo.study.lib_base.R.drawable.icon_default_image_loading) //预览图片
            .errorResId(leo.study.lib_base.R.drawable.icon_default_image_error)  //错误图片
//            .width(300)   //目标宽度
//            .height(300)  //目标高度
            .isCenterCrop(false)  //是否居中裁剪
            .isCenterInside(true) //是否是显示所有居中
//            .config(Bitmap.Config.ARGB_8888) //Bitmap类型
            .build()
        //设置代理类
        ImageLoaderHelper.instance.setImgLoaderProxy(GlideLoaderProcessor(imageOptions))


    }

    /**
     * 初始化智能刷新控件，设置默认头部尾部
     *
     */
    private fun initSmartRefresh(){
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, layout ->
            layout.setPrimaryColorsId(leo.study.lib_base.R.color.color_theme, android.R.color.white) //全局设置主题颜色
            BezierRadarHeader(context) //.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
        }
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, layout -> //指定为经典Footer，默认是 BallPulseFooter
            layout.setPrimaryColorsId(leo.study.lib_base.R.color.color_theme, android.R.color.white) //全局设置主题颜色
            ClassicsFooter(context).setDrawableSize(20f)
        }
    }




}