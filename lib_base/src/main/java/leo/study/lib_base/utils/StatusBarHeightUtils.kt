package leo.study.lib_base.utils

import android.content.Context
import android.util.Log


/**
 *
 * ***********************************************************************
 *the project desc: 安卓状态栏高度获取类 （兼容各大厂商以及异形屏）
 *this name is StatusBarHeightUtils
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年01月31日 17:42:10
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
object StatusBarHeightUtils {

    private val VIVO_NOTCH = 0x00000020 // 是否有刘海

    fun getAllGetStatusBarHeight(context: Context): Int {
        //判断是否是小米刘海屏
        if (XMhasNotchInScreen(context)) {
            return xiaomiGetStatusBarHeight(context)
        }
        //判断 华为
        if (HWhasNotchInScreen(context)) {
            return HWgetNotchSize(context)
        }
        //判断vivo(官方并未修改，默认获取高度)
        if (VIVOhasNotchInScreen(context)) {
            return defaultGetStatusBarHeight(context)
        }
        //判断oppo(官方并未修改，默认获取高度)
        if (OPPOhasNotchInScreen(context)) {
            return defaultGetStatusBarHeight(context)
        }
        //判断魅族
        return if (MeiZuHasNotchInScreen()) {
            MeiZuGetStatusBarHeight(context)
        } else defaultGetStatusBarHeight(context)
        //默认获取高度方法
    }

    /**
     * 默认获取状态栏高度
     *
     * @return
     */
    private fun defaultGetStatusBarHeight(context: Context): Int {
        var result = 0
        val resourceId = context.resources.getIdentifier(
            "status_bar_height",
            "dimen", "android"
        )
        if (resourceId > 0) {
            result = context.resources.getDimensionPixelSize(resourceId)
        }
        return result
    }

    /**
     * 华为凹口屏宽高获取方式 int[]{width, height}
     *
     * @param context
     * @return
     */
    private fun HWgetNotchSize(context: Context): Int {
        var ret = intArrayOf(0, 0)
        try {
            val cl = context.classLoader
            val HwNotchSizeUtil = cl.loadClass("com.huawei.android.util.HwNotchSizeUtil")
            val get = HwNotchSizeUtil.getMethod("getNotchSize")
            ret = get.invoke(HwNotchSizeUtil) as IntArray
        } catch (e: ClassNotFoundException) {
            Log.e("333", "getNotchSize ClassNotFoundException")
        } catch (e: NoSuchMethodException) {
            Log.e("333", "getNotchSize NoSuchMethodException")
        } catch (e: Exception) {
            Log.e("333", "getNotchSize Exception")
        } finally {
            return if (ret[1] == 0) {
                defaultGetStatusBarHeight(context)
            } else ret[1]
        }
    }

    /**
     * 小米获取状态栏的方法（官方）
     *
     * @return 高度值
     */
    private fun xiaomiGetStatusBarHeight(context: Context): Int {
        val resourceId = context.resources.getIdentifier(
            "notch_height",
            "dimen", "android"
        )
        return if (resourceId > 0) {
            context.resources.getDimensionPixelSize(resourceId)
        } else {
            defaultGetStatusBarHeight(context)
        }
    }

    /**
     * 魅族获取状态栏方法
     *
     * @param context
     * @return
     */
    private fun MeiZuGetStatusBarHeight(context: Context): Int {
        val fhid = context.resources.getIdentifier("fringe_height", "dimen", "android")
        return if (fhid > 0) {
            context.resources.getDimensionPixelSize(fhid)
        } else {
            defaultGetStatusBarHeight(context)
        }
    }


    /**
     * 判段魅族是否是刘海屏
     *
     * @return
     */
    private fun MeiZuHasNotchInScreen(): Boolean {
        var isNotch = false
        try {
            val clazz = Class.forName("flyme.config.FlymeFeature")
            val field = clazz.getDeclaredField("IS_FRINGE_DEVICE")
            isNotch = field[null] as Boolean
        } catch (e: Exception) {
            Log.e("ERROR", e.toString())
        } finally {
            return isNotch
        }
    }

    /**
     * 判断是oppo是否有刘海屏
     *
     * @param context
     * @return
     */
    private fun OPPOhasNotchInScreen(context: Context): Boolean {
        var isNotch = false
        try {
            isNotch =
                context.packageManager.hasSystemFeature("com.oppo.feature.screen.heteromorphism")
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
        }
        return isNotch
    }


    /**
     * 判断vivo是否有刘海屏
     *
     * @param context
     * @return true：有刘海屏；false：没有刘海屏
     */
    private fun VIVOhasNotchInScreen(context: Context): Boolean {
        var ret = false
        try {
            val classLoader = context.classLoader
            val FtFeature = classLoader.loadClass("android.util.FtFeature")
            val method = FtFeature.getMethod("isFeatureSupport", Int::class.javaPrimitiveType)
            ret = method.invoke(FtFeature, VIVO_NOTCH) as Boolean
        } catch (e: ClassNotFoundException) {
            Log.e("Notch", "hasNotchAtVivo ClassNotFoundException")
        } catch (e: NoSuchMethodException) {
            Log.e("Notch", "hasNotchAtVivo NoSuchMethodException")
        } catch (e: Exception) {
            Log.e("Notch", "hasNotchAtVivo Exception")
        } finally {
            return ret
        }
    }

    /**
     * 小米凹口屏判断方法判断是否有刘海屏
     *
     * @param context
     * @return true：有刘海屏；false：没有刘海屏
     */
    private fun XMhasNotchInScreen(context: Context): Boolean {
        var ret = false
        try {
            val cl = context.classLoader
            val SystemProperties = cl.loadClass("android.os.SystemProperties")
            val get = SystemProperties.getMethod(
                "getInt",
                String::class.java,
                Int::class.javaPrimitiveType
            )
            ret = get.invoke(SystemProperties, "ro.miui.notch", 0) as Int == 1
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            return ret
        }
    }

    /**
     * 华为凹口屏判断方法 Android 各版本均可
     *
     * @param context
     * @return
     */
    private fun HWhasNotchInScreen(context: Context): Boolean {
        var ret = false
        try {
            val cl = context.classLoader
            val HwNotchSizeUtil = cl.loadClass("com.huawei.android.util.HwNotchSizeUtil")
            val get = HwNotchSizeUtil.getMethod("hasNotchInScreen")
            ret = get.invoke(HwNotchSizeUtil) as Boolean
        } catch (e: ClassNotFoundException) {
            Log.e("333", "hasNotchInScreen ClassNotFoundException")
        } catch (e: NoSuchMethodException) {
            Log.e("333", "hasNotchInScreen NoSuchMethodException")
        } catch (e: Exception) {
            Log.e("333", "hasNotchInScreen Exception")
        } finally {
            return ret
        }
    }

    fun getNavigationBarHeight(context: Context): Int {
        val resources = context.resources
        val resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
        val height = resources.getDimensionPixelSize(resourceId)
        Log.e("333333-navigation", "navigation_height： $height")
        //判断是否是各大厂商是否为异形屏，如果是返回导航栏高度，如果不是返回0
        if (XMhasNotchInScreen(context) ||
            HWhasNotchInScreen(context) ||
            VIVOhasNotchInScreen(context) ||
            OPPOhasNotchInScreen(context) ||
            MeiZuHasNotchInScreen()
        ) {
            return height
        }
        //如果不是各大厂伤，默认为状态栏大于80的就是异形屏
        return if (defaultGetStatusBarHeight(context) > 80) {
            height
        } else 0
        //如果不是异形屏，不设置导航栏间距
    }
}