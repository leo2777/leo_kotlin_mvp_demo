package leo.study.kotlin_mvp_demo.utils

import android.widget.Toast
import androidx.annotation.StringRes
import es.dmoral.toasty.Toasty.*
import leo.study.kotlin_mvp_demo.app.BaseApplication


/**
 *
 * ***********************************************************************
 *the project desc: toasty 吐司工具类
 *this name is ToastyUtils
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年01月16日 17:05:11
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
object ToastyUtils {

    /**
     * 显示成功的 吐司
     *
     * @param [content] 显示内容
     */
    fun showSuccess(content:String){
        success(BaseApplication.getAppContext(),content).show()
    }

    /**
     * 显示成功的 吐司
     *
     * @param [idRes] 资源ID
     */
    fun showSuccess(@StringRes idRes: Int){
        success(BaseApplication.getAppContext(),idRes).show()
    }

    /**
     * 显示成功的 吐司
     *
     * @param [content] 显示内容
     * @param [duration] 显示时长 [Toast.LENGTH_SHORT] 与 [Toast.LENGTH_LONG]
     */
    fun showSuccess(content:String,duration: Int){
        success(BaseApplication.getAppContext(),content,duration).show()
    }

    /**
     * 显示成功的 吐司
     *
     * @param [idRes] 资源ID
     * @param [duration] 显示时长 [Toast.LENGTH_SHORT] 与 [Toast.LENGTH_LONG]
     */
    fun showSuccess(@StringRes idRes: Int,duration: Int){
        success(BaseApplication.getAppContext(),idRes,duration).show()
    }




    /**
     * 显示失败的 吐司
     *
     * @param [content] 显示内容
     */
    fun showError(content:String){
        error(BaseApplication.getAppContext(),content).show()
    }

    /**
     * 显示失败的 吐司
     *
     * @param [idRes] 资源ID
     */
    fun showError(@StringRes idRes: Int){
        error(BaseApplication.getAppContext(),idRes).show()
    }

    /**
     * 显示失败的 吐司
     *
     * @param [content] 显示内容
     * @param [duration] 显示时长 [Toast.LENGTH_SHORT] 与 [Toast.LENGTH_LONG]
     */
    fun showError(content:String,duration: Int){
        error(BaseApplication.getAppContext(),content,duration).show()
    }

    /**
     * 显示失败的 吐司
     *
     * @param [idRes] 资源ID
     * @param [duration] 显示时长 [Toast.LENGTH_SHORT] 与 [Toast.LENGTH_LONG]
     */
    fun showError(@StringRes idRes: Int,duration: Int){
        error(BaseApplication.getAppContext(),idRes,duration).show()
    }






    /**
     * 显示警告的 吐司
     *
     * @param [content] 显示内容
     */
    fun showWarning(content:String){
        warning(BaseApplication.getAppContext(),content).show()
    }

    /**
     * 显示警告的 吐司
     *
     * @param [idRes] 资源ID
     */
    fun showWarning(@StringRes idRes: Int){
        warning(BaseApplication.getAppContext(),idRes).show()
    }

    /**
     * 显示警告的 吐司
     *
     * @param [content] 显示内容
     * @param [duration] 显示时长 [Toast.LENGTH_SHORT] 与 [Toast.LENGTH_LONG]
     */
    fun showWarning(content:String,duration: Int){
        warning(BaseApplication.getAppContext(),content,duration).show()
    }

    /**
     * 显示警告的 吐司
     *
     * @param [idRes] 资源ID
     * @param [duration] 显示时长 [Toast.LENGTH_SHORT] 与 [Toast.LENGTH_LONG]
     */
    fun showWarning(@StringRes idRes: Int,duration: Int){
        warning(BaseApplication.getAppContext(),idRes,duration).show()
    }




    /**
     * 显示通知的 吐司
     *
     * @param [content] 显示内容
     */
    fun showInfo(content:String){
        info(BaseApplication.getAppContext(),content).show()
    }

    /**
     * 显示通知的 吐司
     *
     * @param [idRes] 资源ID
     */
    fun showInfo(@StringRes idRes: Int){
        info(BaseApplication.getAppContext(),idRes).show()
    }

    /**
     * 显示通知的 吐司
     *
     * @param [content] 显示内容
     * @param [duration] 显示时长 [Toast.LENGTH_SHORT] 与 [Toast.LENGTH_LONG]
     */
    fun showInfo(content:String,duration: Int){
        info(BaseApplication.getAppContext(),content,duration).show()
    }

    /**
     * 显示通知的 吐司
     *
     * @param [idRes] 资源ID
     * @param [duration] 显示时长 [Toast.LENGTH_SHORT] 与 [Toast.LENGTH_LONG]
     */
    fun showInfo(@StringRes idRes: Int,duration: Int){
        info(BaseApplication.getAppContext(),idRes,duration).show()
    }





    /**
     * 显示平常的 吐司
     *
     * @param [content] 显示内容
     */
    fun showNormal(content:String){
        normal(BaseApplication.getAppContext(),content).show()
    }

    /**
     * 显示平常的 吐司
     *
     * @param [idRes] 资源ID
     */
    fun showNormal(@StringRes idRes: Int){
        normal(BaseApplication.getAppContext(),idRes).show()
    }

    /**
     * 显示平常的 吐司
     *
     * @param [content] 显示内容
     * @param [duration] 显示时长 [Toast.LENGTH_SHORT] 与 [Toast.LENGTH_LONG]
     */
    fun showNormal(content:String,duration: Int){
        normal(BaseApplication.getAppContext(),content,duration).show()
    }

    /**
     * 显示平常的 吐司
     *
     * @param [idRes] 资源ID
     * @param [duration] 显示时长 [Toast.LENGTH_SHORT] 与 [Toast.LENGTH_LONG]
     */
    fun showNormal(@StringRes idRes: Int,duration: Int){
        normal(BaseApplication.getAppContext(),idRes,duration).show()
    }
}

