package leo.study.kotlin_mvp_demo.ui.test


import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import leo.study.kotlin_mvp_demo.R
import leo.study.kotlin_mvp_demo.databinding.ActivityKotlinTestBinding
import leo.study.kotlin_mvp_demo.utils.ToastyUtils
import leo.study.lib_base.image.ImageLoaderHelper
import leo.study.lib_base.mvp.BaseMvpActivity

class KotlinTestActivity: BaseMvpActivity<ActivityKotlinTestBinding,TestContract.View,TestContract.Presenter>(),TestContract.View,OnClickListener {


    override fun getContext(): BaseMvpActivity<ActivityKotlinTestBinding, TestContract.View, TestContract.Presenter> {
        return this
    }

    override fun getViewBinding(): ActivityKotlinTestBinding {
        return ActivityKotlinTestBinding.inflate(layoutInflater)
    }

    override fun initView() {


        /*binding.buttonSuccess.setOnClickListener {
            ToastyUtils.showSuccess("测试成功吐司")
        }
        binding.buttonError.setOnClickListener {
            ToastyUtils.showError("测试失败吐司")

        }
        binding.buttonInfo.setOnClickListener {
            ToastyUtils.showInfo("测试通知吐司")

        }
        binding.buttonNormal.setOnClickListener {
            ToastyUtils.showNormal("测试标准吐司")

        }
        binding.buttonWarning.setOnClickListener {
            ToastyUtils.showWarning("测试警告吐司")
        }*/

        binding.buttonSuccess.setOnClickListener(this)
        binding.buttonWarning.setOnClickListener(this)
        binding.buttonNormal.setOnClickListener(this)
        binding.buttonInfo.setOnClickListener(this)
        binding.buttonError.setOnClickListener(this)

    }

    override fun initData() {
        presenter.getData()

    }

    override fun getDataSuccess(msg: String?) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
    }

    override var presenter: TestContract.Presenter = TestPresenter();
    override fun onClick(v: View?) {
        if (v == null )return
        when(v.id){
            R.id.button_success ->  ToastyUtils.showSuccess("展示 success 级别吐司")
            R.id.button_error ->  ToastyUtils.showError("展示 error 级别吐司")
            R.id.button_info -> ToastyUtils.showInfo("展示 info 级别吐司")
            R.id.button_normal -> ToastyUtils.showNormal("展示 normal 级别吐司")
            R.id.button_warning -> ToastyUtils.showWarning("展示 warning 级别吐司")
        }
    }

}