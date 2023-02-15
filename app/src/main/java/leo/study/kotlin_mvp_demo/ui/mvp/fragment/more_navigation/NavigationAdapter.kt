package leo.study.kotlin_mvp_demo.ui.mvp.fragment.more_navigation

import android.content.Context
import android.view.ViewGroup
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.QuickViewHolder
import leo.study.kotlin_mvp_demo.R
import leo.study.kotlin_mvp_demo.beans.NaviModel


/**
 *
 * ***********************************************************************
 *the project desc: 更多页面-导航页面-导航数据适配器
 *this name is NavigationDescAdadpter
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月13日 16:15:13
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class NavigationAdapter : BaseQuickAdapter<NaviModel, QuickViewHolder>() {

    fun setSelect(position: Int,oldPosition:Int){
        getItem(oldPosition)?.isSelect = false
        getItem(position)?.isSelect = true
        notifyItemChanged(oldPosition)
        notifyItemChanged(position)
    }

    override fun onBindViewHolder(holder: QuickViewHolder, position: Int, item: NaviModel?) {
        item ?: return
        holder.setText(R.id.tv_ada_more_navi_left_name, item.name)
        holder.itemView.setBackgroundResource(
            if (item.isSelect) R.drawable.shape_solid_white_left_10dp else R.color.transparent_bg_color
        )
    }

    override fun onCreateViewHolder(
        context: Context,
        parent: ViewGroup,
        viewType: Int
    ): QuickViewHolder {
        return QuickViewHolder(R.layout.adapter_more_navi_left_name, parent)
    }
}