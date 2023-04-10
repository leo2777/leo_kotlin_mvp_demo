package leo.study.kotlin_mvp_demo.ui.mvp.activity.collect

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
class CollectAdapter : BaseQuickAdapter<Articles, QuickViewHolder>() {

    override fun onCreateViewHolder(
        context: Context,
        parent: ViewGroup,
        viewType: Int
    ): QuickViewHolder {
        return QuickViewHolder(R.layout.adapter_collect_article, parent)
    }

    override fun onBindViewHolder(holder: QuickViewHolder, position: Int, item: Articles?) {
        val bean: Articles = item!!
        val people  = bean.author.ifEmpty {
            "——"
        }
        holder.setText(R.id.tv_ada_collect_article_people,people)
        holder.setText(R.id.tv_ada_collect_article_date, bean.niceDate)
        holder.setText(R.id.tv_ada_collect_article_title, bean.title)
        holder.setText(R.id.tv_ada_collect_article_category,bean.chapterName)
    }
}