package leo.study.kotlin_mvp_demo.ui.mvp.fragment.wechat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import leo.study.kotlin_mvp_demo.beans.ArticleCategory
import leo.study.kotlin_mvp_demo.databinding.FragmentWeChatBinding
import leo.study.kotlin_mvp_demo.ui.mvp.fragment.wechat_article.WeChatArticleFragment
import leo.study.lib_base.mvp.BaseMvpFragment


class WeChatFragment : BaseMvpFragment<
        FragmentWeChatBinding,
        WeChatContract.View,
        WeChatContract.Presenter>(), WeChatContract.View {

    private var fragments: MutableList<Fragment> = ArrayList()

    private var category: MutableList<ArticleCategory> = ArrayList()

    private var layoutMediator:TabLayoutMediator ?= null

    override var presenter: WeChatContract.Presenter = WeChatPresenter()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentWeChatBinding {
        return FragmentWeChatBinding.inflate(inflater,container,false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        layoutMediator?.detach()
    }

    override fun initView(view: View) {
        presenter.getCategory()
    }

    override fun lazyLoad() {
    }


    private fun setVpAndTab(){
        binding.vpWechatCategory.adapter = (object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                return fragments[position]
            }

            override fun getItemCount(): Int {
                return fragments.size
            }
        })

        layoutMediator = TabLayoutMediator(
            binding.tabWechatCategory, binding.vpWechatCategory,
            false, true
        ) { tab, sum ->
            tab.text = category[sum].name
        }

        layoutMediator?.attach()
    }

    override fun getCategorySuccess(result: MutableList<ArticleCategory>) {
        for (model:ArticleCategory in result){
            val bundle: Bundle = Bundle()
            bundle.putString("authorId", model.id.toString())
            val fragment : WeChatArticleFragment = WeChatArticleFragment()
            fragment.arguments = bundle
            fragments.add(fragment)
        }
        this.category = result
        setVpAndTab()
    }

}