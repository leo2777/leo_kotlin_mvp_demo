package leo.study.kotlin_mvp_demo.ui.mvp.fragment.user

import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import leo.study.kotlin_mvp_demo.R
import leo.study.kotlin_mvp_demo.beans.UserInfoBean
import leo.study.kotlin_mvp_demo.databinding.FragmentUserBinding
import leo.study.kotlin_mvp_demo.ui.mvp.activity.collect.MyCollectActivity
import leo.study.kotlin_mvp_demo.ui.mvp.activity.login_or_register.LoginOrRegisterActivity
import leo.study.lib_base.ext.*
import leo.study.lib_base.mvp.BaseMvpFragment


class UserFragment : BaseMvpFragment<FragmentUserBinding, Contract.View, Contract.Presenter>(),
    Contract.View, OnClickListener {


    override var presenter: Contract.Presenter = Presenter()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentUserBinding {
        return FragmentUserBinding.inflate(inflater, container, false)
    }

    override fun onEveryResume() {
        super.onEveryResume()
        presenter.getIsLogin()
    }


    override fun initView(view: View) {
        setClickViews(
            binding.linMyGrade,
            binding.linMyCollect,
            binding.linMyShare,
            binding.linSetting,
            binding.linMyAbout,
            binding.linNoLogin,
            binding.btnLogin
        )
    }

    override fun lazyLoad() {
    }

    override fun onUserInfoResult(result: UserInfoBean) {
        result.run {
            if (this.userInfo.icon.isEmpty()){
                binding.imgUserHead.loadCircle(R.mipmap.icon_default_head)
            }else{
                binding.imgUserHead.loadCircle(this.userInfo.icon)
            }
            binding.tvMeId.text = this.userInfo.id.toString()
            binding.tvMeLevel.text = "等级：${this.coinInfo.level}"
            binding.tvMeName.text = this.userInfo.nickname
            binding.tvMeRank.text = "排名：${this.coinInfo.rank}"
            binding.tvMyGrade.text = this.userInfo.coinCount.toString()
        }
    }

    override fun onIsLogin(login: Boolean) {
        if (login) {
            binding.linNoLogin.visibility = GONE
            presenter.getUserInfo()
        } else {
            binding.linNoLogin.visibility = VISIBLE
        }

    }

    override fun onClick(view: View?) {
        view ?: return
        when (view.id) {
            R.id.lin_my_about -> {
            }
            R.id.lin_my_collect -> requireContext().startActivity<MyCollectActivity>()
            R.id.lin_setting -> {

            }
            R.id.lin_my_share -> {

            }
            R.id.lin_my_grade -> {

            }
            R.id.btn_login -> requireContext().startActivity<LoginOrRegisterActivity>()
        }
    }

}