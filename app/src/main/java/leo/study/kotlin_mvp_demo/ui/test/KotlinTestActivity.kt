package leo.study.kotlin_mvp_demo.ui.test

import android.view.View
import android.widget.Toast
import leo.study.kotlin_mvp_demo.databinding.ActivityKotlinTestBinding
import leo.study.kotlin_mvp_demo.utils.ToastyUtils
import leo.study.lib_base.mvp.BaseMvpActivity

class KotlinTestActivity : BaseMvpActivity<TestContract.View,TestContract.Presenter>(),TestContract.View {


    private lateinit var binding: ActivityKotlinTestBinding;

    override fun getContentView(): View {
        binding = ActivityKotlinTestBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun getContext(): BaseMvpActivity<TestContract.View, TestContract.Presenter> {
        return this
    }

    override fun initView() {


        binding.buttonSuccess.setOnClickListener {
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
        }
    }

    override fun initData() {
        presenter.getData()
    }

    override fun getDataSuccess(msg: String?) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
    }

    override var presenter: TestContract.Presenter = TestPresenter();
}