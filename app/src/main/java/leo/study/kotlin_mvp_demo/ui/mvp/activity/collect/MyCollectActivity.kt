package leo.study.kotlin_mvp_demo.ui.mvp.activity.collect

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import android.webkit.RenderProcessGoneDetail
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener
import leo.study.kotlin_mvp_demo.R
import leo.study.kotlin_mvp_demo.beans.ArticlePage
import leo.study.kotlin_mvp_demo.beans.Articles
import leo.study.kotlin_mvp_demo.databinding.ActivityMyCollectBinding
import leo.study.kotlin_mvp_demo.ui.activity.CommonWebViewActivity
import leo.study.lib_base.ext.startActivity
import leo.study.lib_base.mvp.BaseMvpActivity

class MyCollectActivity :BaseMvpActivity<ActivityMyCollectBinding,Contract.View,Contract.Presenter>(),Contract.View {

    private val firstPage = 0

    private var pageNum = firstPage

    private val adapter:CollectAdapter by lazy { CollectAdapter() }

    override var presenter: Contract.Presenter  = Presenter()


    override fun getViewBinding(): ActivityMyCollectBinding {
        return ActivityMyCollectBinding.inflate(layoutInflater)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home ->  finish()
        }
        return true
    }

    override fun initView() {

        setSupportActionBar(binding.toolbarMyCollect)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.tvTitle.visibility = VISIBLE
        binding.tvTitle.text = "我的收藏列表"

        initAdapter()
    }



    override fun initData() {
        presenter.refreshList()
    }


    private fun initAdapter() {

        binding.refreshMyCollect.setOnRefreshLoadMoreListener(object : OnRefreshLoadMoreListener {
            override fun onLoadMore(refreshLayout: RefreshLayout) {
                pageNum++
                presenter.loadList(pageNum)
            }

            override fun onRefresh(refreshLayout: RefreshLayout) {
                pageNum = firstPage
                presenter.refreshList()
            }
        })

        binding.recMyCollect.adapter = this.adapter

        adapter.setOnItemClickListener{ _,_,position ->
            val bundle = Bundle()
            bundle.putString("url",adapter.getItem(position)?.link)
            bundle.putString("name",adapter.getItem(position)?.title)
            startActivity<CommonWebViewActivity>(bundle)
        }
    }

    override fun onMyCollectList(result: ArticlePage) {

        binding.refreshMyCollect.finishRefresh()
        binding.refreshMyCollect.finishLoadMore()


        binding.refreshMyCollect.setNoMoreData(result.over)

        if (pageNum == firstPage){
            adapter.submitList(result.articles)
        }else{
            adapter.addAll(result.articles)
        }
    }

}