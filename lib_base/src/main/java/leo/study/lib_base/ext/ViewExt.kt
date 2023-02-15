package leo.study.lib_base.ext

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat


/**
 *
 * ***********************************************************************
 *the project desc: view 的扩展类，包函点击事件等等
 *this name is ViewExt
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月06日 10:22:12
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
//todo:后续需要继续添加公用方法

val Context.screenWidthPx: Int get() = resources.displayMetrics.widthPixels
val Context.screenHeightPx: Int get() = resources.displayMetrics.heightPixels
val Context.screenWidthDp: Int get() = screenWidthPx.px2dp(this)
val Context.screenHeightDp: Int get() = screenHeightPx.px2dp(this)


/**
 * View 点击事件
 *
 * @param [click] 事件处理
 */
fun View.onClick(click: () -> Unit) {
    this.apply { setOnClickListener { click() } }
}

/**
 * View 长按事件
 *
 * @param [click] 事件处理
 */
fun View.onLongClick(click: () -> Boolean) {
    this.apply { setOnLongClickListener { click() } }
}

/**
 * 绑定多个点击事件
 *
 * @param [views] 多个事件id 逗号隔开
 */
fun View.OnClickListener.setClickViews(vararg views: View) {
    let {
        for (view in views) {
            view.setOnClickListener(it)
        }
    }
}

//私有扩展属性，允许2次点击的间隔时间
private var <T : View> T.delayTime: Long
    get() = getTag(0x7FFF0001) as? Long ?: 0
    set(value) {
        setTag(0x7FFF0001, value)
    }

//私有扩展属性，记录点击时的时间戳
private var <T : View> T.lastClickTime: Long
    get() = getTag(0x7FFF0002) as? Long ?: 0
    set(value) {
        setTag(0x7FFF0002, value)
    }

//私有扩展方法，判断能否触发点击事件
private fun <T : View> T.canClick(): Boolean {
    var flag = false
    var now = System.currentTimeMillis()
    if (now - this.lastClickTime >= this.delayTime) {
        flag = true
        this.lastClickTime = now
    }
    return flag
}


/**
 * 扩展点击事件，默认 500ms 内不能触发 2 次点击
 *
 * @param [time] 时间，毫秒
 * @param [click] 点击事件
 */
fun View.clickWithDuration(time: Long = 500, click: () -> Unit) {
    delayTime = time
    this.apply {
        setOnClickListener {
            if (canClick()){
                click()
            }
        }
    }
}

/**
 * 获取 资源颜色
 *
 * @param [id] 颜色 资源id
 */
fun Context.getCompatColor(@ColorRes id: Int):Int = ContextCompat.getColor(this, id)

/**
 * 获取 资源 drawable
 *
 * @param [id] ID
 */
fun Context.getCompatDrawable(@DrawableRes id: Int):Drawable = ContextCompat.getDrawable(this, id)!!


fun Float.dp2px() = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    this,
    Resources.getSystem().displayMetrics
)


fun Int.dp2px() = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    this.toFloat(),
    Resources.getSystem().displayMetrics
).toInt()


//根据手机的分辨率从 px(像素) 的单位 转成为 dp
fun Int.px2dp(context: Context): Int {
    val scale = context.resources.displayMetrics.density
    return (this / scale + 0.5f).toInt()
}

