package leo.study.lib_base.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment


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
abstract class BaseFragment : Fragment() {

    open var mContext: Context? = null

    private var isLazyLoad = false


    protected abstract fun lazyLoad()

    @LayoutRes
    protected abstract fun getContentView(): Int;


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = getContentView()
        val rootView = inflater.inflate(layout, container, false)
        this.mContext = context
        return rootView;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        savedStanceState(savedInstanceState)
        initView(view)
    }

    override fun onResume() {
        super.onResume()
        if (!isLazyLoad){
            lazyLoad()
            isLazyLoad = true
        }

    }

    protected abstract fun initView(view : View)

    open fun savedStanceState(savedInstanceState : Bundle?){}




    override fun onDestroy() {
        super.onDestroy()
    }

}