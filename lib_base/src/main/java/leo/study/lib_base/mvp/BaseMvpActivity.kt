package leo.study.lib_base.mvp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.RelativeLayout
import android.widget.Toast
import leo.study.lib_base.R
import leo.study.lib_base.base.BaseActivity

abstract class BaseMvpActivity<V : ITopView, P : ITopPresenter> : BaseActivity(), IView<P> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initEnd()
    }

    override fun getContext() = this


    override fun showLoading(isTimer: Boolean) {
        if (isTimer)
            progressDialog?.showProgressTimeDialog()
        else
            progressDialog?.showProgressDialog()
    }

    override fun showLoading(msg: String, isTimer: Boolean) {
        if (isTimer)
            progressDialog?.showProgressMsgTimeDialog(msg)
        else
            progressDialog?.showProgressMsgDialog(msg)
    }

    override fun showLoading(msgId: Int, isTimer: Boolean) {
        if (isTimer)
            progressDialog?.showProgressMsgTimeDialog(resources.getString(msgId))
        else
            progressDialog?.showProgressMsgDialog(resources.getString(msgId))
    }

    override fun finish(resultCode: Int) {
        finish()
    }

    override fun dismissLoading() {
        progressDialog?.dismissProgressDialog()
    }

    override fun showToast(message: String) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun showToast(messageId: Int) {
        Toast.makeText(getContext(), messageId, Toast.LENGTH_SHORT).show()
    }
}