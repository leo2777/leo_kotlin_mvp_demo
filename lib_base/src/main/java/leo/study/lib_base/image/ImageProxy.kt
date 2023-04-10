package leo.study.lib_base.image

import android.view.View
import java.io.File


/**
 *
 * ***********************************************************************
 *the project desc: 图片加载代理接口类  图片加载操作代理方法，用于暴露接口给使用者调用
 *this name is ImageProxy
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年01月17日 15:48:56
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
interface ImageProxy {
    /**
     * 加载图片  网络地址
     * @param [view] 显示的view
     * @param [path] 加载地址
     * @return 当前的代理类
     */
    fun loadImage(view: View?, path: String?): ImageProxy

    /**
     * 加载资源图， R.drawable...
     * @param [view] 显示的view
     * @param [drawable] 资源地址
     * @return 当前的代理类
     */
    fun loadImage(view: View?, drawable: Int): ImageProxy

    /**
     * 显示图片文件
     * @param [view] 显示的view
     * @param [file] 资源文件
     * @return 当前的代理类
     */
    fun loadImage(view: View?, file: File?): ImageProxy

    /**
     * 加载GIF
     * @param [view] 显示的view
     * @param [url] 图片地址
     * @return 当前代理类
     */
    fun loadGif(view: View?, url: String?): ImageProxy

//    /**
//     * 加载自定义高宽图片
//     * @param [view] 显示的view
//     * @param [url] 图片地址
//     * @param [width] 图片宽度 px
//     * @param [height] 图片高度 px
//     * @return 当前代理类
//     */
//    fun loadTargetWidthAndHeight(
//        view: View?,
//        url: String?,
//        width: Int,
//        height: Int,
//    ): ImageProxy


    /**
     * 加载缩略图
     * @param [view] 显示的view
     * @param [url] 图片地址
     * @param [scan] 缩略数，百分比
     * @return 当前代理类
     */
    fun loadThumb(view: View?, url: String?, scan: Float): ImageProxy

    /**
     * 加载圆形图片
     * @param [view] 显示view
     * @param [url] 图片地址
     * @return 当前代理类
     */
    fun loadCircleImage(view: View?, url: String?): ImageProxy


    /**
     * 加载圆形图片
     * @param [view] 显示view
     * @param [url] 图片地址
     * @return 当前代理类
     */
    fun loadCircleImage(view: View?, url: Int?): ImageProxy

    /**
     * 加载圆角图片
     * @param [view] 显示的view
     * @param [url] 图片地址
     * @param [shapeValue] 半径值
     * @return 当前代理类
     */
    fun loadRoundImage(view: View?, url: String?, shapeValue: Int): ImageProxy


    /**
     * 获取drawable
     *
     * @param [url]      地址
     * @param [loaderCallback] 结果回调
     * @return 当前代理类
     */
    fun getDrawable(url: String?, loaderCallback: ImageLoaderCallback?):ImageProxy


    /**
     * 设置图片加载参数
     *
     * @return 返回当前
     */
    fun setImgLoaderOptions(options: ImageOptions?): ImageProxy

    /**
     * 清理内存缓存
     * @return 当前代理类
     */
    fun clearMemoryCache(): ImageProxy

    /**
     * 清理磁盘缓存
     * @return 当前代理类
     */
    fun clearDiskCache(): ImageProxy
}