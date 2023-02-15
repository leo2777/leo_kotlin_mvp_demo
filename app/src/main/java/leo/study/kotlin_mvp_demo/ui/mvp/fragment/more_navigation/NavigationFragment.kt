package leo.study.kotlin_mvp_demo.ui.mvp.fragment.more_navigation

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.QuickViewHolder
import leo.study.kotlin_mvp_demo.beans.NaviModel
import leo.study.kotlin_mvp_demo.databinding.FragmentMoreNaviBinding
import leo.study.lib_base.mvp.BaseMvpFragment


/**
 *
 * ***********************************************************************
 *the project desc: 更多页面 fragment - 导航fragment
 *this name is NavigationFragment
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月08日 15:33:22
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class NavigationFragment :
    BaseMvpFragment<FragmentMoreNaviBinding, NavigationContract.View, NavigationContract.Presenter>(),
    NavigationContract.View {

    override var presenter: NavigationContract.Presenter = NavigationPresenter()

    private val adapter by lazy { NavigationAdapter() }


    private var fragments: MutableList<Fragment> = ArrayList()

    /**
     * 左边列表以及viewpager 选中的指标值，
     * 当前左边的RecyclerView 单选的逻辑是 默认第一次选中第一，
     * 后面只更新选中的position 和 旧position
     * 如：第一次进入默认选择第一个，接下来如果点击了第二个，只刷新第一个和第二个，其他不变
     */
    private var oldPosition:Int = 0


    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMoreNaviBinding {
        return FragmentMoreNaviBinding.inflate(inflater, container, false)
    }

    override fun initView(view: View) {

        binding.recMoreNaviCategory.adapter = this.adapter
        adapter.setOnItemClickListener { adapter, view, position ->
            binding.vpMoreNaviDesc.currentItem = position
            this.adapter.setSelect(position,oldPosition)
            oldPosition = position
        }

        binding.vpMoreNaviDesc.registerOnPageChangeCallback(object :OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                adapter.setSelect(position,oldPosition)
                oldPosition = position
                binding.recMoreNaviCategory.scrollToPosition(position)
            }
        })


        presenter.getData()
    }

    override fun lazyLoad() {
    }

    private fun setViewPager() {
        binding.vpMoreNaviDesc.adapter = (object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                return fragments[position]
            }

            override fun getItemCount(): Int {
                return fragments.size
            }
        })
    }

    override fun getDataSuccess(result: MutableList<NaviModel>) {
        for (model: NaviModel in result) {
            val bundle: Bundle = Bundle()
            bundle.putString("name", model.name)
            bundle.putParcelableArrayList("list", model.articles)
            val fragment = NavigationDescFragment()
            fragment.arguments = bundle
            fragments.add(fragment)
        }
        setViewPager()
        result[0].isSelect = true
        adapter.submitList(result)
    }

}