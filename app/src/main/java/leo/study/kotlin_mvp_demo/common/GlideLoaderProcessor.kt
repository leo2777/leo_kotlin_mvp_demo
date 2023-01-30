package leo.study.kotlin_mvp_demo.common

import android.graphics.drawable.Drawable
import android.os.Looper
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import leo.study.lib_base.image.ImageLoaderCallback
import leo.study.lib_base.image.ImageOptions
import leo.study.lib_base.image.ImageProxy
import java.io.File


/**
 *
 * ***********************************************************************
 *the project desc: Glide 图片显示实现类
 *this name is GlideLoaderProcessor
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年01月17日 16:41:52
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
open class GlideLoaderProcessor(options: ImageOptions?) : ImageProxy {

    private var proxy: ImageProxy? = null;

    private val options: ImageOptions;

    private val requestOptions: RequestOptions = RequestOptions()


    init {
        this.options = options!!
        setShareOptions()
    }

    /**
     * 设置共享的options
     */
    private fun setShareOptions() {
        //设置是否局部裁剪显示
        if (options.isCenterCrop) requestOptions.centerCrop().options
        //设置是否全图居中
        if (options.isCenterInside) requestOptions.centerInside().options
        //设置加载错误图片
        if (options.errorResId != 0) requestOptions.error(options.errorResId).options
        //设置加载中显示的图片
        if (options.placeholderResId != 0) requestOptions.placeholder(options.placeholderResId).options
        //设置加载的宽高
        if (options.targetHeight != 0 && options.targetWidth != 0) requestOptions.override(
            options.targetWidth,
            options.targetHeight
        ).options


        //·······  如果还需要更多属性设置，请完善ImgLoaderOptions类之后，再进行操作
    }


    private fun obtain(): ImageProxy {
        return this
    }


    /**
     * 加载图片  网络地址
     * @param [view] 显示的view
     * @param [path] 加载地址
     * @return 当前的代理类
     */
    override fun loadImage(view: View?, path: String?): ImageProxy {
        if (view is ImageView) {
            options.context?.let {
                Glide
                    .with(it)
                    .setDefaultRequestOptions(requestOptions)
                    .load(path)
                    .into(view)
            }
        }
        return obtain()
    }

    /**
     * 加载资源图， R.drawable...
     * @param [view] 显示的view
     * @param [drawable] 资源地址
     * @return 当前的代理类
     */
    override fun loadImage(view: View?, drawable: Int): ImageProxy {
        if (view is ImageView) {
            options.context?.let {
                Glide
                    .with(it)
                    .setDefaultRequestOptions(requestOptions)
                    .asDrawable()
                    .load(drawable)
                    .into(view)
            }
        }
        return obtain()
    }

    /**
     * 显示图片文件
     * @param [view] 显示的view
     * @param [file] 资源文件
     * @return 当前的代理类
     */
    override fun loadImage(view: View?, file: File?): ImageProxy {
        if (view is ImageView) {
            options.context?.let {
                Glide
                    .with(it)
                    .setDefaultRequestOptions(requestOptions)
                    .asFile()
                    .load(file)
                    .into(view)
            }
        }
        return obtain()
    }

    /**
     * 加载GIF
     * @param [view] 显示的view
     * @param [url] 图片地址
     * @return 当前代理类
     */
    override fun loadGif(view: View?, url: String?): ImageProxy {
        if (view is ImageView) {
            options.context?.let {
                Glide
                    .with(it)
                    .setDefaultRequestOptions(requestOptions)
                    .asGif()
                    .load(url)
                    .into(view)
            }
        }

        return obtain()
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
//        TODO("Not yet implemented")
//    }

    /**
     * 加载缩略图
     * @param [view] 显示的view
     * @param [url] 图片地址
     * @param [scan] 缩略数，百分比
     * @return 当前代理类
     */
    override fun loadThumb(view: View?, url: String?, scan: Float): ImageProxy {
        if (view is ImageView) {
            options.context?.let {
                Glide
                    .with(it)
                    .setDefaultRequestOptions(requestOptions)
                    .load(url)
                    .thumbnail(scan)
                    .into(view)
            }
        }
        return obtain()
    }

    /**
     * 加载圆形图片
     * @param [view] 显示view
     * @param [url] 图片地址
     * @return 当前代理类
     */
    override fun loadCircleImage(view: View?, url: String?): ImageProxy {
        if (view is ImageView) {
            options.context?.let {
                Glide
                    .with(it)
                    .setDefaultRequestOptions(requestOptions)
                    .applyDefaultRequestOptions(RequestOptions.bitmapTransform(CircleCrop()))
                    .load(url)
                    .into(view)
            }
        }
        return obtain()
    }

    /**
     * 加载圆角图片
     * @param [view] 显示的view
     * @param [url] 图片地址
     * @param [shapeValue] 半径值
     * @return 当前代理类
     */
    override fun loadRoundImage(view: View?, url: String?, shapeValue: Int): ImageProxy {
        if (view is ImageView) {
            options.context?.let {
                Glide
                    .with(it)
                    .setDefaultRequestOptions(requestOptions)
                    .applyDefaultRequestOptions(
                        RequestOptions.bitmapTransform(
                            RoundedCorners(
                                shapeValue
                            )
                        )
                    )
                    .load(url)
                    .into(view)
            }
        }
        return obtain()
    }

    /**
     * 获取drawable
     *
     * @param [url]      地址
     * @param [loaderCallback] 结果回调
     * @return 当前代理类
     */
    override fun getDrawable(url: String?, loaderCallback: ImageLoaderCallback?): ImageProxy {
        Glide
            .with(options.context!!)
            .load(url)
            .listener(object : RequestListener<Drawable?> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable?>?,
                    isFirstResource: Boolean,
                ): Boolean {
                    loaderCallback!!.onFail("图片下载失败！")
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable?>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean,
                ): Boolean {
                    if (resource != null) {
                        loaderCallback!!.onSuccess(resource, "图片下载成功！")
                        return false
                    }
                    loaderCallback!!.onFail("图片下载失败！")
                    return false
                }
            })
            .submit()
        return obtain()
    }

    /**
     * 设置图片加载参数
     *
     * @return 返回当前
     */
    override fun setImgLoaderOptions(options: ImageOptions?): ImageProxy {
        return proxy!!.setImgLoaderOptions(options)
    }

    /**
     * 清理内存缓存
     * @return 当前代理类
     */
    override fun clearMemoryCache(): ImageProxy {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                options.context?.let {
                    Glide.get(it)
                        .clearMemory()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return obtain()
    }

    /**
     * 清理磁盘缓存
     * @return 当前代理类
     */
    override fun clearDiskCache(): ImageProxy {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                Thread {
                    options.context?.let { Glide.get(it).clearDiskCache() }
                }.start()
            } else {
                options.context?.let {
                    Glide.get(it)
                        .clearDiskCache()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return obtain()
    }

}