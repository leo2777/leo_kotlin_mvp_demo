package leo.study.kotlin_mvp_demo.ui.activity

import android.view.MenuItem
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationBarView
import leo.study.kotlin_mvp_demo.R
import leo.study.kotlin_mvp_demo.databinding.ActivityMainBinding
import leo.study.kotlin_mvp_demo.ui.fragment.MoreFragment
import leo.study.kotlin_mvp_demo.ui.mvp.fragment.project.ProjectFragment
import leo.study.kotlin_mvp_demo.ui.mvp.fragment.more_square.SquareFragment
import leo.study.kotlin_mvp_demo.ui.fragment.UserFragment
import leo.study.kotlin_mvp_demo.ui.mvp.fragment.wechat.WeChatFragment
import leo.study.kotlin_mvp_demo.ui.mvp.fragment.home.HomeFragment
import leo.study.lib_base.base.BaseActivity

//首页
class MainActivity : BaseActivity<ActivityMainBinding>(), NavigationBarView.OnItemSelectedListener {

    private val homeFragmentIndex = 0x01
    private val projectFragmentIndex = 0x02
    private val squareFragmentIndex = 0x03
    private val weChatFragmentIndex = 0x04
    private val userFragmentIndex = 0x05

    private var index = homeFragmentIndex

    private var homeFragment: HomeFragment? = null
    private var moreFragment: MoreFragment? = null
    private var weChatFragment: WeChatFragment? = null
    private var projectFragment: ProjectFragment? = null
    private var userFragment: UserFragment? = null


    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {

        binding.navView.setOnItemSelectedListener(this)
        showFragment(index)


//        startActivity<KotlinTestActivity>()
    }

    override fun initData() {

    }

    /**
     * 显示fragment
     *
     * @param index 指标
     */
    private fun showFragment(index: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        hideFragment(transaction)

        when (index) {
            homeFragmentIndex -> {
                binding.toolbarActivityMain.title = getString(R.string.title_home)
                if (homeFragment == null) {
                    homeFragment = HomeFragment()
                    transaction.add(R.id.frame_fragment_activity_main, homeFragment!!, "首页")
                } else {
                    transaction.show(homeFragment!!)
                }
            }
            projectFragmentIndex -> {
                binding.toolbarActivityMain.title = getString(R.string.title_project)
                if (projectFragment == null) {
                    projectFragment = ProjectFragment()
                    transaction.add(R.id.frame_fragment_activity_main, projectFragment!!, "项目")
                } else {
                    transaction.show(projectFragment!!)
                }
            }
            squareFragmentIndex -> {
                binding.toolbarActivityMain.title = getString(R.string.title_square)
                if (moreFragment == null) {
                    moreFragment = MoreFragment()
                    transaction.add(R.id.frame_fragment_activity_main, moreFragment!!, "更多")
                } else {
                    transaction.show(moreFragment!!)
                }
            }
            weChatFragmentIndex -> {
                binding.toolbarActivityMain.title = getString(R.string.title_we_chat)
                if (weChatFragment == null) {
                    weChatFragment = WeChatFragment()
                    transaction.add(R.id.frame_fragment_activity_main, weChatFragment!!, "公众号")
                } else {
                    transaction.show(weChatFragment!!)
                }
            }
            userFragmentIndex -> {
                binding.toolbarActivityMain.title = getString(R.string.title_user)
                if (userFragment == null) {
                    userFragment = UserFragment()
                    transaction.add(R.id.frame_fragment_activity_main, userFragment!!, "个人")
                } else {
                    transaction.show(userFragment!!)
                }
            }
        }

        transaction.commit()
    }

    private fun hideFragment(transaction: FragmentTransaction) {
        homeFragment?.let { transaction.hide(it) }
        projectFragment?.let { transaction.hide(it) }
        moreFragment?.let { transaction.hide(it) }
        weChatFragment?.let { transaction.hide(it) }
        userFragment?.let { transaction.hide(it) }
    }

    private fun releaseFragment(){
        homeFragment = null
        projectFragment = null
        moreFragment = null
        weChatFragment = null
        userFragment = null
    }

    /**
     * 底部按钮监听
     *
     * @param item 第几个
     * @return
     */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.navigation_home -> {
                showFragment(homeFragmentIndex)
                true
            }
            R.id.navigation_project -> {
                showFragment(projectFragmentIndex)
                true
            }
            R.id.navigation_square -> {
                showFragment(squareFragmentIndex)
                true
            }
            R.id.navigation_we_chat -> {
                showFragment(weChatFragmentIndex)
                true
            }
            R.id.navigation_mine -> {
                showFragment(userFragmentIndex)
                true
            }
            else -> false
        }
    }

    override fun recreate() {
        try {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            if (homeFragment != null) {
                fragmentTransaction.remove(homeFragment!!)
            }
            if (moreFragment != null) {
                fragmentTransaction.remove(moreFragment!!)
            }
            if (projectFragment != null) {
                fragmentTransaction.remove(projectFragment!!)
            }
            if (weChatFragment != null) {
                fragmentTransaction.remove(weChatFragment!!)
            }
            if (userFragment != null) {
                fragmentTransaction.remove(userFragment!!)
            }
            fragmentTransaction.commitAllowingStateLoss()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        super.recreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        releaseFragment()
    }
}