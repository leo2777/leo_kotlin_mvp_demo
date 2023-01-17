package leo.study.lib_base.image

import android.graphics.drawable.Drawable


/**
 *
 * ***********************************************************************
 *the project desc: 图片加载操作结果回调
 *this name is ImageLoaderCallback
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年01月17日 15:44:01
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
interface ImageLoaderCallback {

    /**
     * 加载成功返回
     *
     * @param [drawable] drawable
     * @param [message] 信息
     */
    fun onSuccess(drawable:Drawable,message:String)

    /**
     * 加载失败返回
     *
     * @param [message] 返回失败信息
     */
    fun onFail(message: String)
}