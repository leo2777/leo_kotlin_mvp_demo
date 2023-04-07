package leo.study.kotlin_mvp_demo.ui.mvp.fragment.more_system

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.QuickViewHolder
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import leo.study.kotlin_mvp_demo.R
import leo.study.kotlin_mvp_demo.beans.SystemBean
import leo.study.kotlin_mvp_demo.beans.SystemChildrenBean
import leo.study.kotlin_mvp_demo.databinding.FragmentSystemBinding
import leo.study.kotlin_mvp_demo.ui.activity.CommonWebViewActivity
import leo.study.lib_base.ext.startActivity
import leo.study.lib_base.mvp.BaseMvpFragment


/**
 *
 * ***********************************************************************
 *the project desc: 更多fragment - 体系 fragment
 *this name is SystemFragment
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月08日 15:36:05
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class SystemFragment :
    BaseMvpFragment<FragmentSystemBinding, SystemContract.View, SystemContract.Presenter>(),
    SystemContract.View {


    override var presenter: SystemContract.Presenter = SystemPresenter()

    private var adapter: BaseQuickAdapter<SystemBean, QuickViewHolder>? = null

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSystemBinding {
        return FragmentSystemBinding.inflate(inflater, container, false)
    }

    override fun initView(view: View) {
        setAdapter()

        presenter.getSystemData()
    }


    override fun lazyLoad() {
    }

    private fun setAdapter() {

        //列表适配器
        adapter = (object : BaseQuickAdapter<SystemBean, QuickViewHolder>() {
            override fun onBindViewHolder(
                holder: QuickViewHolder,
                position: Int,
                item: SystemBean?
            ) {
                item ?: return
                holder.setText(R.id.tv_ada_more_system_category_name, item.name)
                val recChild =
                    holder.getView<RecyclerView>(R.id.rec_ada_more_system_category_child_list)
                val layoutManager = FlexboxLayoutManager(mContext)
                layoutManager.flexDirection = FlexDirection.ROW
                layoutManager.flexWrap = FlexWrap.WRAP
                val childAdapter  = (object : BaseQuickAdapter<SystemChildrenBean, QuickViewHolder>() {
                    override fun onBindViewHolder(
                        holder: QuickViewHolder,
                        position: Int,
                        item: SystemChildrenBean?
                    ) {
                        holder.setIsRecyclable(false)
                        item ?: return
                        holder.setText(R.id.tv_ada_more_system_category_child_name, item.name)
                    }

                    override fun onCreateViewHolder(
                        context: Context,
                        parent: ViewGroup,
                        viewType: Int
                    ): QuickViewHolder {
                        return QuickViewHolder(R.layout.adapter_more_system_category_child_name, parent)
                    }

                })
                recChild.adapter = childAdapter
                recChild.layoutManager = layoutManager

                childAdapter.submitList(item.children)
            }

            override fun onCreateViewHolder(
                context: Context,
                parent: ViewGroup,
                viewType: Int
            ): QuickViewHolder {
                return QuickViewHolder(R.layout.adapter_more_system_category, parent)
            }

        })


        binding.recMoreSystemCategoryList.adapter = this.adapter
    }


    override fun getSystemSuccess(result: MutableList<SystemBean>) {
        adapter?.submitList(result)
    }
}