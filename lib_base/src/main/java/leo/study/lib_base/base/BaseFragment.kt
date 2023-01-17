package leo.study.lib_base.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding


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


    open var mContext: Context? = null

    private var isLazyLoad = false


    /**
     * 绑定当前的fragment
     *
     * @param [inflater] 布局
     * @param [container] 父类
     * @return [ViewBinding]
     */
    protected abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): T
    protected abstract fun lazyLoad()


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
        initView(view)

    }

    override fun onResume() {
        super.onResume()
        if (!isLazyLoad) {
            lazyLoad()
            isLazyLoad = true
        }

    }

    protected abstract fun initView(view: View)

    open fun savedStanceState(savedInstanceState: Bundle?) {}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}