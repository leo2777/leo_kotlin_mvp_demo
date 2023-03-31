package leo.study.lib_base.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import leo.study.lib_base.R
import leo.study.lib_base.utils.ProgressDialogUtils


/**
 *
 * ***********************************************************************
 *the project desc: 基础Fragment
 *this name is BaseFragment
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2022年11月08日 15:05:32
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
abstract class BaseFragment<T : ViewBinding> : Fragment() {


    private var _binding: T? = null
    protected val binding get() = _binding!!



    private var progressDialog: ProgressDialogUtils? = null
    open var mContext: Context? = null

    private var isLazyLoad = false


    /**
     * 绑定当前的fragment
     *
     * @param [inflater] 布局
     * @param [container] 父类
     * @return  绑定
     */
    protected abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): T
    protected abstract fun initView(view: View)
    protected abstract fun lazyLoad()

    /**
     * 每次显示回调
     *  注意：宿主Activity 必须是 调用 show/hide ,而不能是 replace,否则需要自己实现。
     *
     *  */
    protected open fun onEveryResume(){}



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        isLazyLoad = false
        _binding = getViewBinding(inflater,container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        savedStanceState(savedInstanceState)
        mContext = context
        progressDialog = context?.let { ProgressDialogUtils(it, R.style.commonDialogStyle) }

        initView(view)
    }

    override fun onResume() {
        super.onResume()
        if (!isLazyLoad) {
            lazyLoad()
            isLazyLoad = true
        }
        if (!isHidden){
            onEveryResume()
        }

    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden){
            onEveryResume()
        }
    }


    open fun savedStanceState(savedInstanceState: Bundle?) {}


    fun showProgressDialog(text: String) {
        progressDialog?.showProgressMsgDialog(text)
    }

    fun showProgressDialogTimeOut(text: String){
        progressDialog?.showProgressMsgTimeDialog(text)
    }


    fun dismissProgressDialog() {
        progressDialog?.dismissProgressDialog()
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}