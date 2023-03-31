package leo.study.kotlin_mvp_demo.ui.mvp.activity.login_or_register

import android.view.View
import android.view.View.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import leo.study.kotlin_mvp_demo.R
import leo.study.kotlin_mvp_demo.beans.LoginAndRegisterBean
import leo.study.kotlin_mvp_demo.constants.Constants
import leo.study.kotlin_mvp_demo.databinding.ActivityLoginOrRegisterBinding
import leo.study.lib_base.ext.dataStorePut
import leo.study.lib_base.mvp.BaseMvpActivity

class LoginOrRegisterActivity :
    BaseMvpActivity<ActivityLoginOrRegisterBinding, Contract.View, Contract.Presenter>(),
    Contract.View, OnClickListener {

    private var isLoginOrRegister = true // true 登录，false 注册

    override var presenter: Contract.Presenter = Presenter()


    override fun getViewBinding(): ActivityLoginOrRegisterBinding {
        return ActivityLoginOrRegisterBinding.inflate(layoutInflater)
    }

    override fun initView() {
        binding.tvTopLoginOrRegister.setOnClickListener(this)
        binding.tvBack.setOnClickListener(this)
        binding.btnNext.setOnClickListener(this)
    }


    override fun initData() {
    }

    override fun onLoginResult(bean: LoginAndRegisterBean) {
        MainScope().launch {
            dataStorePut(Constants.IS_LOGIN,true)
            bean.run {

            }
        }

        binding.tvBack.performClick()
    }

    override fun onRegisterResult(bean: LoginAndRegisterBean) {
        MainScope().launch {
            dataStorePut(Constants.IS_LOGIN,true)
            bean.run {

            }
        }
        binding.tvBack.performClick()
    }

    override fun onChangeResult() {
        if (isLoginOrRegister){
            binding.tvTopLoginOrRegister.text = "注册"
            binding.tvBottomTitle.text = "登录"
            binding.btnNext.text = "登录"
            binding.ediConfirmPassword.visibility = GONE
            return
        }

        binding.tvTopLoginOrRegister.text = "登录"
        binding.tvBottomTitle.text = "注册"
        binding.btnNext.text = "注册"
        binding.ediConfirmPassword.visibility = VISIBLE
    }

    override fun onClick(view: View?) {
        view ?: return
        when (view.id) {
            R.id.tv_top_login_or_register -> {
                isLoginOrRegister = !isLoginOrRegister
                presenter.change()
            }
            R.id.tv_back -> finish()
            R.id.btn_next ->
                if (isLoginOrRegister) presenter.login(
                binding.ediNumber.text.toString(),
                binding.ediPassword.text.toString()
            ) else presenter.register(
                binding.ediNumber.text.toString(),
                binding.ediPassword.text.toString(),
                binding.ediConfirmPassword.text.toString()
            )
        }
    }

}