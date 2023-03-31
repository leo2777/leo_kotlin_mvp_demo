package leo.study.lib_base.base

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.PersistableBundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding
import leo.study.lib_base.R
import leo.study.lib_base.utils.ActivityUtils
import leo.study.lib_base.utils.ProgressDialogUtils
import leo.study.lib_base.utils.StatusBarUtils
import kotlin.properties.Delegates


/**
 *
 * ***********************************************************************
 *the project desc: Activity 基类
 *this name is BaseActivity
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2022年11月08日 14:30:10
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {

    private lateinit var _binding:T
    protected val binding get() = _binding

    open var context: Context by Delegates.notNull()

    open var progressDialog: ProgressDialogUtils? = null
    open fun onSetContentViewNext(savedInstanceState: Bundle?) {}


    /**
     * 绑定控件
     *
     * @return viewBinding
     */
    abstract fun getViewBinding():T


    abstract fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        super.onCreate(savedInstanceState)
        //强制竖屏
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        context = this
        _binding = getViewBinding()
        setContentView(_binding.root)
        setStatesBar()
        initView()
        progressDialog = ProgressDialogUtils(this, R.style.commonDialogStyle)
        onSetContentViewNext(savedInstanceState)
        ActivityUtils.pushActivity(this)
    }

    /**
     * 设置状态栏 actionBar
     */
    private fun setStatesBar() {
    }



    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (ev != null && ev.action == MotionEvent.ACTION_UP) {
            val v = currentFocus
            //如果不是落在EditText区域，则需要关闭输入法
            if (hideKeyboard(v, ev)) {
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(v!!.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    // 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘
    private fun hideKeyboard(view: View?, event: MotionEvent?): Boolean {
        if (view != null && event != null && view is EditText) {

            val location = intArrayOf(0, 0)
            view.getLocationInWindow(location)

            //获取现在拥有焦点的控件view的位置，即EditText
            val left = location[0]
            val top = location[1]
            val bottom = top + view.height
            val right = left + view.width
            //判断我们手指点击的区域是否落在EditText上面，如果不是，则返回true，否则返回false
            val isInEt = (event.x > left && event.x < right && event.y > top
                    && event.y < bottom)
            return !isInEt
        }
        return false
    }

    override fun onDestroy() {
        ActivityUtils.removeActivity(this)
        super.onDestroy()
    }
}