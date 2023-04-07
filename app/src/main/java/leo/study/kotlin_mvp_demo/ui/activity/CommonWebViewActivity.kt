package leo.study.kotlin_mvp_demo.ui.activity

import android.view.KeyEvent
import android.view.MenuItem
import android.widget.RelativeLayout
import com.just.agentweb.AgentWeb
import leo.study.kotlin_mvp_demo.R
import leo.study.kotlin_mvp_demo.databinding.ActivityCommonWebViewBinding
import leo.study.lib_base.base.BaseActivity
import leo.study.lib_base.ext.getCompatColor

class CommonWebViewActivity : BaseActivity<ActivityCommonWebViewBinding>() {

    private var agentWeb: AgentWeb? = null

    private var url = ""


    override fun getViewBinding(): ActivityCommonWebViewBinding {
        return ActivityCommonWebViewBinding.inflate(layoutInflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                agentWeb?.let {
                    if (it.webCreator.webView.canGoBack()) {
                        it.back()
                    } else {
                        finish()
                    }
                }
            }
        }
        return true
    }

    override fun initView() {

        url = intent.extras!!.getString("url", "")

        setSupportActionBar(binding.toolbarWeb)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.tvTitle.text = intent.extras!!.getString("name", "")


        buildAgentWeb()
    }

    private fun buildAgentWeb() {
        agentWeb = AgentWeb.with(this)
            .setAgentWebParent(binding.relWeb, RelativeLayout.LayoutParams(-1, -1))
            .useDefaultIndicator(getCompatColor(R.color.color_theme), 2)
            .interceptUnkownUrl()
            .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
            .createAgentWeb()
            .ready()
            .go(url)
    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return if (agentWeb != null && agentWeb!!.handleKeyEvent(keyCode, event)) {
            true
        } else super.onKeyDown(keyCode, event)
    }
}