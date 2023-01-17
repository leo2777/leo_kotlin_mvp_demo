package leo.study.lib_base.utils

import android.app.Activity
import android.util.Log
import java.util.*


/**
 *
 * ***********************************************************************
 *the project desc: Activity 操作类
 *this name is ActivityUtils
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2022年12月16日 11:42:26
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
object ActivityUtils {

    private const val TAG = "ActivityUtils"
    private val activityStack: Stack<Activity> = Stack()

    /**
     * <获取当前栈顶Activity>
     */
    private fun curActivity(): Activity? {
        return if (activityStack.size == 0) {
            null
        } else activityStack.lastElement()
    }


    /**
     * <获取当前栈顶Activity>
     * <功能详细描述>
     * @see [类、类.方法、类.成员]
     */
    fun popCurrentActivity() {
        exitPopActivity(curActivity())
    }


    /**
     * <将Activity入栈>
     * <功能详细描述>
     *
     * @param activity
     * @see [类、类.方法、类.成员]
    </功能详细描述></将Activity入栈> */
    fun pushActivity(activity: Activity) {
        activityStack.add(activity)
    }

    /**
     * <退出栈顶Activity>
     * <功能详细描述>
     * @see [类、类.方法、类.成员]
     */
    private fun exitPopActivity(activity: Activity?) {
        if (activity != null) {
            activity.finish()
            Log.e(TAG, "remove current activity:" + activity.javaClass.simpleName)
            activityStack.remove(activity)
        }
    }


    /**
     * 将制定activity从栈中移除
     */
    fun removeActivity(activity: Activity?) {
        if (activity != null) {
            activityStack.remove(activity)
        }
    }


    /**
     * <退出栈中所有Activity></退出栈中所有Activity>,当前的activity除外>
     * <功能详细描述>
     *
     * @param cls
     * @see [类、类.方法、类.成员]
    </功能详细描述> */
    fun popAllActivityExceptMain(cls: Class<*>) {
        while (true) {
            val activity = curActivity() ?: break
            if (activity.javaClass == cls) {
                break
            }
            exitPopActivity(activity)
        }
    }


    fun popAllActivity() {
        while (true) {
            val activity = curActivity() ?: break
            exitPopActivity(activity)
        }
    }

    /**
     * 如果栈顶是这个 class 就finish掉
     */
    fun exitPopActivity(activityClass: Class<out Activity>) {
        val activity = curActivity()
        if (activity != null && activity.javaClass.name == activityClass.name) {
            exitPopActivity(activity)
        }
    }

    fun getSize(): Int {
        return activityStack.size
    }
}