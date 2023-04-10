package leo.study.lib_base.image

import android.view.View
import java.io.File


/**
 *
 * ***********************************************************************
 *the project desc: 图片加载代理主类
 *
 * 图片加载主类，图片加载调用此类，通过代理类实现，无缝简单切换图片加载框架
 * 如果想要切换图片加载框架，只需要新建一个类集成 ImageLoaderProxy 并实现
 * 里面的方法，不需要关注项目中的图片加载方法
 *
 *this name is ImageLoaderHelper
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年01月17日 16:13:09
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class ImageLoaderHelper private constructor() : ImageProxy {

    companion object {
        val instance: ImageLoaderHelper by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            ImageLoaderHelper()
        }
    }

    private var proxy: ImageProxy? = null;


    /**
     * 判断是否设置了代理类，这个为必须设置，
     */
    private fun judgeProxyNullable() {
        if (proxy == null) {
            throw NullPointerException("请先设置图片加载代理类！！！")
        }
    }

    fun setImgLoaderProxy(imageProxy: ImageProxy) {
        if (proxy == null) {
            proxy = imageProxy
        }
    }


    /**
     * 加载图片  网络地址
     * @param [view] 显示的view
     * @param [path] 加载地址
     * @return 当前的代理类
     */
    override fun loadImage(view: View?, path: String?): ImageProxy {
        judgeProxyNullable()
        return proxy?.loadImage(view, path)!!
    }

    /**
     * 加载资源图， R.drawable...
     * @param [view] 显示的view
     * @param [drawable] 资源地址
     * @return 当前的代理类
     */
    override fun loadImage(view: View?, drawable: Int): ImageProxy {
        judgeProxyNullable()
        return proxy?.loadImage(view, drawable)!!
    }

    /**
     * 显示图片文件
     * @param [view] 显示的view
     * @param [file] 资源文件
     * @return 当前的代理类
     */
    override fun loadImage(view: View?, file: File?): ImageProxy {
        judgeProxyNullable()
        return proxy?.loadImage(view, file)!!
    }

    /**
     * 加载GIF
     * @param [view] 显示的view
     * @param [url] 图片地址
     * @return 当前代理类
     */
    override fun loadGif(view: View?, url: String?): ImageProxy {
        judgeProxyNullable()
        return proxy?.loadImage(view, url)!!
    }

//    /**
//     * 加载自定义高宽图片
//     * @param [view] 显示的view
//     * @param [url] 图片地址
//     * @param [width] 图片宽度 px
//     * @param [height] 图片高度 px
//     * @return 当前代理类
//     */
//    override fun loadTargetWidthAndHeight(
//        view: View?,
//        url: String?,
//        width: Int,
//        height: Int,
//    ): ImageProxy {
//        judgeProxyNullable()
//        return proxy?.loadTargetWidthAndHeight(view, url, width, height)!!
//    }

    /**
     * 加载缩略图
     * @param [view] 显示的view
     * @param [url] 图片地址
     * @param [scan] 缩略数，百分比
     * @return 当前代理类
     */
    override fun loadThumb(view: View?, url: String?, scan: Float): ImageProxy {
        judgeProxyNullable()
        return proxy?.loadThumb(view, url, scan)!!
    }

    /**
     * 加载圆形图片
     * @param [view] 显示view
     * @param [url] 图片地址
     * @return 当前代理类
     */
    override fun loadCircleImage(view: View?, url: String?): ImageProxy {
        judgeProxyNullable()
        return proxy?.loadCircleImage(view, url)!!
    }

    override fun loadCircleImage(view: View?, url: Int?): ImageProxy {
        judgeProxyNullable()
        return proxy?.loadCircleImage(view, url)!!
    }

    /**
     * 加载圆角图片
     * @param [view] 显示的view
     * @param [url] 图片地址
     * @param [shapeValue] 半径值
     * @return 当前代理类
     */
    override fun loadRoundImage(view: View?, url: String?, shapeValue: Int): ImageProxy {
        judgeProxyNullable()
        return proxy?.loadRoundImage(view, url, shapeValue)!!
    }

    /**
     * 获取drawable
     *
     * @param [url]      地址
     * @param [loaderCallback] 结果回调
     * @return 当前代理类
     */
    override fun getDrawable(url: String?, loaderCallback: ImageLoaderCallback?): ImageProxy {
        judgeProxyNullable()
        return proxy?.getDrawable(url, loaderCallback)!!
    }

    /**
     * 设置图片加载参数
     *
     * @return 返回当前
     */
    override fun setImgLoaderOptions(options: ImageOptions?): ImageProxy {
        judgeProxyNullable()
        return proxy?.setImgLoaderOptions(options)!!
    }

    /**
     * 清理内存缓存
     * @return 当前代理类
     */
    override fun clearMemoryCache(): ImageProxy {
        judgeProxyNullable()
        return proxy?.clearMemoryCache()!!
    }

    /**
     * 清理磁盘缓存
     * @return 当前代理类
     */
    override fun clearDiskCache(): ImageProxy {
        judgeProxyNullable()
        return proxy?.clearDiskCache()!!
    }
}