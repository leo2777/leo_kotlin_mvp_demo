package leo.study.kotlin_mvp_demo.ui.test

import android.widget.Toast
import leo.study.kotlin_mvp_demo.R
import leo.study.lib_base.mvp.BaseMvpActivity

class KotlinTestActivity : BaseMvpActivity<TestContract.View,TestContract.Presenter>(),TestContract.View {



    override fun getContentView(): Int {
        return R.layout.activity_kotlin_test
    }

    override fun getContext(): BaseMvpActivity<TestContract.View, TestContract.Presenter> {
        return this
    }

    override fun initView() {
    }

    override fun initData() {
        presenter.getData()
    }

    override fun getDataSuccess(msg: String?) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
    }

    override var presenter: TestContract.Presenter = TestPresenter();
}