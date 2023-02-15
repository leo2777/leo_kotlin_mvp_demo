package leo.study.kotlin_mvp_demo.ui.mvp.fragment.more_navigation

import android.content.Context
import android.view.ViewGroup
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.QuickViewHolder
import leo.study.kotlin_mvp_demo.R
import leo.study.kotlin_mvp_demo.beans.Articles
import leo.study.lib_base.ext.getCompatColor


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
class NavigationDescAdapter : BaseQuickAdapter<Articles, QuickViewHolder>() {

    val color = intArrayOf(
        R.color.color_r0_BB86FC,
        R.color.color_r1_FF5722,
        R.color.color_r2_F44336,
        R.color.color_r3_03A9F4,
        R.color.color_r4_FFEB3B,
        R.color.color_r5_4CAF50,
        R.color.color_r6_FF9800,
        R.color.color_r7_3F51B5,
        R.color.color_r8_089282,
        R.color.color_r9_CDDC39
    )

    override fun onBindViewHolder(holder: QuickViewHolder, position: Int, item: Articles?) {
        item ?: return
        val tvName: TextView = holder.getView(R.id.tv_ada_more_navi_right_name)
        tvName.text = item.title
        tvName.setTextColor(context.getCompatColor(color.random()))
    }

    override fun onCreateViewHolder(
        context: Context,
        parent: ViewGroup,
        viewType: Int
    ): QuickViewHolder {
        return QuickViewHolder(R.layout.adapter_more_navi_right_name, parent)
    }
}