package leo.study.kotlin_mvp_demo.ui.mvp.fragment.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import leo.study.kotlin_mvp_demo.beans.ProjectCategory
import leo.study.kotlin_mvp_demo.databinding.FragmentProjectBinding
import leo.study.kotlin_mvp_demo.ui.mvp.fragment.project_article.ProjectArticleFragment
import leo.study.lib_base.ext.showLogD
import leo.study.lib_base.mvp.BaseMvpFragment

/**
 * 项目分页
 */
class ProjectFragment : BaseMvpFragment<
        FragmentProjectBinding,
        ProjectContract.View,
        ProjectContract.Presenter>(), ProjectContract.View {


    private var fragments: MutableList<Fragment> = ArrayList()

    private var category: MutableList<ProjectCategory> = ArrayList()

    private var layoutMediator:TabLayoutMediator ?= null

    override var presenter: ProjectContract.Presenter = ProjectPresenter()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentProjectBinding {
        return FragmentProjectBinding.inflate(inflater, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        layoutMediator?.detach()
    }

    override fun initView(view: View) {
        showLogD("请求数据")
        presenter.getCategory()
    }

    override fun lazyLoad() {
    }

    private fun setVpAndTab(){
        binding.vpProjectCategory.adapter = (object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                return fragments[position]
            }

            override fun getItemCount(): Int {
                return fragments.size
            }
        })

        layoutMediator = TabLayoutMediator(
            binding.tabProjectCategory, binding.vpProjectCategory,
            false, true
        ) { tab, sum ->
            tab.text = category[sum].name
        }

        layoutMediator?.attach()
    }


    override fun getCategorySuccess(result: MutableList<ProjectCategory>) {
        for (model:ProjectCategory in result){
            val bundle:Bundle = Bundle()
            bundle.putString("id", model.id.toString())
            val fragment : ProjectArticleFragment = ProjectArticleFragment()
            fragment.arguments = bundle
            fragments?.add(fragment)
        }
        this.category = result
        setVpAndTab()
    }

}