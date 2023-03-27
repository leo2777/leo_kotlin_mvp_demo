package leo.study.lib_base.mvp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.viewbinding.ViewBinding
import es.dmoral.toasty.Toasty
import leo.study.lib_base.R
import leo.study.lib_base.base.BaseActivity

abstract class BaseMvpActivity<T:ViewBinding,V : ITopView, P : ITopPresenter> : BaseActivity<T>(), IView<P> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initEnd()
        initData()
    }


    abstract fun initData()

    override fun getCtx() = this


    override fun showLoading(isTimer: Boolean) {
        if (isTimer)
            progressDialog?.showProgressMsgTimeDialog("")
        else
            progressDialog?.showProgressMsgDialog("")
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
        Toasty.info(getCtx(),message,Toast.LENGTH_SHORT).show()
    }

    override fun showToast(@StringRes messageId: Int) {
        Toasty.info(getCtx(),messageId,Toast.LENGTH_SHORT).show()
    }
}