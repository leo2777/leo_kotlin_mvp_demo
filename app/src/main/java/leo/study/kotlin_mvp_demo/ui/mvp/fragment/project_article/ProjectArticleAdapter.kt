package leo.study.kotlin_mvp_demo.ui.mvp.fragment.project_article

import android.content.Context
import android.view.ViewGroup
import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.QuickViewHolder
import leo.study.kotlin_mvp_demo.R
import leo.study.kotlin_mvp_demo.beans.Articles
import leo.study.lib_base.ext.load


/**
 *
 * ***********************************************************************
 *the project desc: 项目页面-子页面-项目列表适配器
 *this name is ProjectArticleAdapter
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月07日 17:41:20
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class ProjectArticleAdapter : BaseQuickAdapter<Articles,QuickViewHolder>() {


    override fun onBindViewHolder(holder: QuickViewHolder, position: Int, item: Articles?) {
        item!!
        holder.getView<ImageView>(R.id.img_ada_project_article_pic).load(item.envelopePic)

        holder.setText(R.id.tv_ada_project_article_title,item.title)
        holder.setText(R.id.tv_ada_project_article_desc,item.desc)
        holder.setText(R.id.tv_ada_project_article_people,item.author)
        holder.setText(R.id.tv_ada_project_article_time,item.niceDate)

        holder.setImageResource(
            R.id.img_ada_project_article_collect,
            if (item.collect) R.drawable.icon_home_article_collect_select
            else R.drawable.icon_home_article_collect_default
        )
    }

    override fun onCreateViewHolder(
        context: Context,
        parent: ViewGroup,
        viewType: Int
    ): QuickViewHolder {
        return QuickViewHolder(R.layout.adapter_project_article,parent)
    }
}