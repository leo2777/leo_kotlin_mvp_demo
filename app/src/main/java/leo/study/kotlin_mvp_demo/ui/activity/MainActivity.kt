package leo.study.kotlin_mvp_demo.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import leo.study.kotlin_mvp_demo.R
import leo.study.lib_base.base.BaseActivity

//首页
class MainActivity : BaseActivity() {

    //地步选择栏按钮id 集合
    private val appBarConfiguration = AppBarConfiguration(
        setOf(
            R.id.navigation_home,
            R.id.navigation_project,
            R.id.navigation_square,
            R.id.navigation_we_chat,
            R.id.navigation_mine
        )
    )


    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        //设置底部选择栏
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        setupActionBarWithNavController(navController, appBarConfiguration)
        nav_view.setupWithNavController(navController)
    }

    override fun initData() {

    }
}