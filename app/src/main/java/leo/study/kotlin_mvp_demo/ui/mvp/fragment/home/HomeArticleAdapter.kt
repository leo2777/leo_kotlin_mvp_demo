package leo.study.kotlin_mvp_demo.ui.mvp.fragment.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.QuickViewHolder
import leo.study.kotlin_mvp_demo.R
import leo.study.kotlin_mvp_demo.beans.Articles
import leo.study.lib_base.image.ImageLoaderHelper


/**
 *
 * ***********************************************************************
 *the project desc: 首页 文章列表适配器
 *this name is HomeArticleAdapter
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月03日 09:43:53
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class HomeArticleAdapter : BaseQuickAdapter<Articles, QuickViewHolder>() {

    override fun onCreateViewHolder(
        context: Context,
        parent: ViewGroup,
        viewType: Int
    ): QuickViewHolder {
        return QuickViewHolder(R.layout.adapter_home_article, parent)
    }

    override fun onBindViewHolder(holder: QuickViewHolder, position: Int, item: Articles?) {
        val bean: Articles = item!!
        if (bean.top == "1") {
            holder.setGone(R.id.tv_ada_home_article_tag_one, false)
            holder.setText(R.id.tv_ada_home_article_tag_one, "置顶")
        } else if (bean.fresh) {
            holder.setGone(R.id.tv_ada_home_article_tag_one, false)
            holder.setText(R.id.tv_ada_home_article_tag_one, "最新")
        } else {
            holder.setGone(R.id.tv_ada_home_article_tag_one, true)
        }

        if (bean.tags.isNotEmpty()) {
            holder.setGone(R.id.tv_ada_home_article_tag_two, false)
            holder.setText(R.id.tv_ada_home_article_tag_two, bean.tags[0].name)
        } else {
            holder.setGone(R.id.tv_ada_home_article_tag_two, true)
        }

        holder.setText(R.id.tv_ada_home_article_people, bean.author.ifEmpty { "未知作者" })
        holder.setText(R.id.tv_ada_home_article_date, bean.niceDate)
        holder.setText(R.id.tv_ada_home_article_title, bean.title)
        holder.setText(
            R.id.tv_ada_home_article_category,
            bean.superChapterName + "/" + bean.chapterName
        )

        holder.setImageResource(
            R.id.img_ada_home_article_collect,
            if (bean.collect) R.drawable.icon_home_article_collect_select
            else R.drawable.icon_home_article_collect_default
        )


    }
}