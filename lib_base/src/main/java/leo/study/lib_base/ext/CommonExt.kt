package leo.study.lib_base.ext

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.Nullable
import androidx.annotation.StringRes
import com.orhanobut.logger.Logger
import com.orhanobut.logger.Logger.ERROR
import es.dmoral.toasty.Toasty
import leo.study.lib_base.ext.px2dp
import leo.study.lib_base.image.ImageLoaderHelper
import java.io.File


/**
 *
 * ***********************************************************************
 *the project desc: 公用调用扩展类 。（吐司，log 等等）
 *this name is CommonExt
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月06日 10:36:39
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */

//TODO: kotlin 公用 扩展函数 工具类，后续项目开发需要增加相对应的扩展函数。



//=================================================================================================


/**
 * 跳转
 */

/**
 * 不带参数跳转Activity  如：startActivity<TestActivity>()
 *
 * @param [T] 跳转的Activity
 */
inline fun <reified T : Activity> Context.startActivity() {
    let {
        val intent = Intent(this, T::class.java)
        it.startActivity(intent)
    }
}

/**
 * 带参数跳转的Activity  如：startActivity<TestActivity>()
 *
 * @param [T]跳转的Activity
 * @param [data]携带的数据
 */
inline fun <reified T : Activity> Context.startActivity(data: Bundle) {
    let {
        val intent = Intent(this, T::class.java)
        intent.putExtras(data)
        it.startActivity(intent)
    }
}


//=================================================================================================


/**
 * 显示成功的 吐司
 *
 * 使用方法： 「context」.showSuccess(......)
 */
fun Context.showSuccess(content: String) {
    this.let { Toasty.success(it, content).show() }
}

fun Context.showSuccess(@StringRes idRes: Int) {
    this.let { Toasty.success(it, idRes).show() }
}

fun Context.showSuccess(content: String, duration: Int) {
    this.let { Toasty.success(it, content, duration).show() }
}

fun Context.showSuccess(@StringRes idRes: Int, duration: Int) {
    this.let { Toasty.success(it, idRes, duration).show() }
}

/**
 * 显示失败的 吐司
 *
 * 使用方法： 「context」.showError(......)
 */
fun Context.showError(content: String) {
    this.let { Toasty.error(it, content).show() }
}

fun Context.showError(@StringRes idRes: Int) {
    this.let { Toasty.error(it, idRes).show() }
}

fun Context.showError(content: String, duration: Int) {
    this.let { Toasty.error(it, content, duration).show() }
}

fun Context.showError(@StringRes idRes: Int, duration: Int) {
    this.let { Toasty.error(it, idRes, duration).show() }
}

/**
 * 显示警告的 吐司
 *
 * 使用方法： 「context」.showWarning(......)
 */
fun Context.showWarning(content: String) {
    this.let { Toasty.warning(this, content).show() }
}

fun Context.showWarning(@StringRes idRes: Int) {
    this.let { Toasty.warning(this, idRes).show() }
}

fun Context.showWarning(content: String, duration: Int) {
    this.let { Toasty.warning(this, content, duration).show() }
}

fun Context.showWarning(@StringRes idRes: Int, duration: Int) {
    this.let { Toasty.warning(this, idRes, duration).show() }
}


/**
 * 显示通知的 吐司
 *
 * 使用方法： 「context」.showInfo(......)
 */
fun Context.showInfo(content: String) {
    this.let { Toasty.info(it, content).show() }
}

fun Context.showInfo(@StringRes idRes: Int) {
    this.let { Toasty.info(it, idRes).show() }
}

fun Context.showInfo(content: String, duration: Int) {
    this.let { Toasty.info(it, content, duration).show() }
}

fun Context.showInfo(@StringRes idRes: Int, duration: Int) {
    this.let { Toasty.info(it, idRes, duration).show() }
}


/**
 * 显示平常的 吐司
 *
 * 使用方法： 「context」.showNormal(......)
 */
fun Context.showNormal(content: String) {
    this.let { Toasty.normal(it, content).show() }
}

fun Context.showNormal(@StringRes idRes: Int) {
    this.let { Toasty.normal(it, idRes).show() }
}

fun Context.showNormal(content: String, duration: Int) {
    this.let { Toasty.normal(it, content, duration).show() }
}

fun Context.showNormal(@StringRes idRes: Int, duration: Int) {
    this.let { Toasty.normal(it, idRes, duration).show() }
}


//=================================================================================================


/**
 * log 扩展函数
 */
fun showLogE(content: String) {
    Logger.e(content)
}
fun showLogE(tag:String,content: String) {
    Logger.t(tag).e(content)
}

fun showLogI(content: String) {
    Logger.i(content)
}
fun showLogI(tag:String,content: String) {
    Logger.t(tag).i(content)
}

fun showLogV(content: String) {
    Logger.v(content)
}
fun showLogV(tag:String,content: String) {
    Logger.t(tag).v(content)
}

fun showLogD(content: String) {
    Logger.d(content)
}
fun showLogD(tag:String,content: String) {
    Logger.t(tag).d(content)
}

fun showLogW(content: String) {
    Logger.w(content)
}
fun showLogW(tag:String,content: String) {
    Logger.t(tag).w(content)
}


//=================================================================================================


/**
 * 图片加载ext
 *
 * 使用  imageView.load(......)
 */
/**
 * 加载 网络图片
 *
 * @param [url] 网络地址
 */
fun ImageView.load(url: String) {
    let { ImageLoaderHelper.instance.loadImage(it, url) }
}

/**
 * 加载drawable资源图片
 *
 * @param [id] ID
 */
fun ImageView.load(@DrawableRes id: Int) {
    let { ImageLoaderHelper.instance.loadImage(it, id) }
}

/**
 * 加载文件图片
 *
 * @param [file] 文件类
 */
fun ImageView.load(file: File) {
    let { ImageLoaderHelper.instance.loadImage(it, file) }
}

/**
 * 加载GIF
 *
 * @param [url] GIF地址
 */
fun ImageView.loadGif(url: String) {
    let { ImageLoaderHelper.instance.loadGif(it, url) }
}

/**
 * 加载图片并裁剪成圆形
 *
 * @param [url] 图片地址
 */
fun ImageView.loadCircle(url: String) {
    let { ImageLoaderHelper.instance.loadCircleImage(it, url) }
}

/**
 * 加载图片 并设定 圆角
 *
 * @param [url] 图片地址
 * @param [round] 圆角值 单位：dp
 */
fun ImageView.loadRound(url: String, round: Int) {
    let { ImageLoaderHelper.instance.loadRoundImage(it, url, round.px2dp(it.context)) }
}
