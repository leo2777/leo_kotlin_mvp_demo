package leo.study.kotlin_mvp_demo.ui.mvp.fragment.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import leo.study.kotlin_mvp_demo.R
import leo.study.kotlin_mvp_demo.databinding.FragmentUserBinding
import leo.study.lib_base.base.BaseFragment


class UserFragment : BaseFragment<FragmentUserBinding>() {
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentUserBinding {
        return FragmentUserBinding.inflate(inflater,container,false)
    }

    override fun initView(view: View) {
    }

    override fun lazyLoad() {
    }

}