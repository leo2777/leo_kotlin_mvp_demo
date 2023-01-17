package leo.study.kotlin_mvp_demo.ui.activity

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationBarView
import leo.study.kotlin_mvp_demo.R
import leo.study.kotlin_mvp_demo.databinding.ActivityMainBinding
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

    private lateinit var binding: ActivityMainBinding


    override fun getContentView(): View {
        binding = ActivityMainBinding.inflate(layoutInflater)
        return binding.root
    }




    override fun initView() {


        //设置底部选择栏
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)



    }

    override fun initData() {

    }
}