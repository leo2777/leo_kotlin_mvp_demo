package leo.study.lib_base.image

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Bitmap.Config
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CenterInside


/**
 *
 * ***********************************************************************
 *the project desc: 图片代理配置类
 *this name is ImageOptions
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年01月17日 15:57:33
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class ImageOptions {

    var placeholderResId: Int = 0    //占位符资源地址
    var errorResId: Int = 0          //错误图片资源地址
    var isCenterCrop: Boolean = false    //是否是占满剧中
    var isCenterInside: Boolean = false  //是否是显示所有居中
    var config: Bitmap.Config = Bitmap.Config.RGB_565    //位图 config
    var targetWidth: Int = 0         //设置目标宽
    var targetHeight: Int = 0       //设置目标高
    var context: Context? = null         //当前的上下文


    class Builder(context: Context) {

        private var imageOptions: ImageOptions = ImageOptions()


        init {
            imageOptions.context = context
        }


        fun placeholderResId(idRes: Int): Builder {
            imageOptions.placeholderResId = idRes
            return this
        }

        fun errorResId(idRes: Int): Builder {
            imageOptions.errorResId = idRes
            return this
        }

        fun isCenterCrop(boolean: Boolean): Builder {
            imageOptions.isCenterCrop = boolean
            return this
        }

        fun isCenterInside(boolean: Boolean): Builder {
            imageOptions.isCenterInside = boolean
            return this
        }

        fun config(config: Config): Builder {
            imageOptions.config = config
            return this
        }


        fun width(num: Int): Builder {
            imageOptions.targetWidth = num
            return this
        }


        fun height(num: Int): Builder {
            imageOptions.targetHeight = num
            return this
        }

        fun build(): ImageOptions {
            return imageOptions
        }


    }
}