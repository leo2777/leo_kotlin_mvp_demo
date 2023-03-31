package leo.study.kotlin_mvp_demo.ui.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.launch
import leo.study.kotlin_mvp_demo.databinding.FragmentMoreBinding
import leo.study.kotlin_mvp_demo.ui.mvp.fragment.more_navigation.NavigationFragment
import leo.study.kotlin_mvp_demo.ui.mvp.fragment.more_square.SquareFragment
import leo.study.kotlin_mvp_demo.ui.mvp.fragment.more_system.SystemFragment
import leo.study.lib_base.base.BaseFragment
import leo.study.lib_base.ext.dataStoreGet


/**
 *
 * ***********************************************************************
 *the project desc: 更多 fragment
 *this name is MoreFragment
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月08日 15:28:34
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class MoreFragment : BaseFragment<FragmentMoreBinding>() {

    private val tabName: List<String> = listOf("广场", "导航", "体系")
    private val fragments: List<Fragment> =
        listOf(SquareFragment(), NavigationFragment(), SystemFragment())
    private var layoutMediator: TabLayoutMediator? = null


    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMoreBinding {
        return FragmentMoreBinding.inflate(inflater, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        layoutMediator?.detach()
    }

    override fun initView(view: View) {


//        var name: String = ""
//        lifecycleScope.launch {
//            name = requireContext().dataStoreGet("name")
//        }



        binding.vpMoreChildFragment.adapter = (object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                return fragments[position]
            }

            override fun getItemCount(): Int {
                return fragments.size
            }
        })

        layoutMediator = TabLayoutMediator(
            binding.tabMoreChildFragment, binding.vpMoreChildFragment,
            false, true
        ) { tab, sum ->
            tab.text = tabName[sum]
        }

        layoutMediator?.attach()
    }

    override fun lazyLoad() {
    }
}