package leo.study.kotlin_mvp_demo.ui.mvp.fragment.more_navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.QuickViewHolder
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import leo.study.kotlin_mvp_demo.beans.Articles
import leo.study.kotlin_mvp_demo.databinding.FragmentMoreNaviDescBinding
import leo.study.kotlin_mvp_demo.ui.activity.CommonWebViewActivity
import leo.study.lib_base.base.BaseFragment
import leo.study.lib_base.ext.startActivity


/**
 *
 * ***********************************************************************
 *the project desc: 更多-导航页面-分类详情子页面
 *this name is NavigationDescFragment
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月13日 13:44:29
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class NavigationDescFragment : BaseFragment<FragmentMoreNaviDescBinding>() {

    private var list: ArrayList<Articles>? = null
    private var name: String? = null

    private val adapter: BaseQuickAdapter<Articles, QuickViewHolder> by lazy {
        NavigationDescAdapter()
    }


    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMoreNaviDescBinding {
        return FragmentMoreNaviDescBinding.inflate(inflater, container, false)
    }

    override fun setArguments(args: Bundle?) {
        super.setArguments(args)
        args ?: return
        list = args.getParcelableArrayList("list")
        name = args.getString("name")
    }

    override fun initView(view: View) {
        binding.tvMoreNaviDescCategoryName.text = name

        val layoutManager = FlexboxLayoutManager(mContext)
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.flexWrap = FlexWrap.WRAP

        binding.recMoreNaviDescCategoryList.layoutManager = layoutManager
        binding.recMoreNaviDescCategoryList.adapter = this.adapter

        adapter.setOnItemClickListener{ _,_,position ->
            val bundle = Bundle()
            bundle.putString("url",adapter.getItem(position)?.link)
            bundle.putString("name",adapter.getItem(position)?.title)
            requireContext().startActivity<CommonWebViewActivity>(bundle)
        }
    }


    override fun lazyLoad() {
        adapter.submitList(list)
    }
}