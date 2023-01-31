package leo.study.lib_base.mvp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import es.dmoral.toasty.Toasty
import leo.study.lib_base.base.BaseFragment


/**
 *
 * ***********************************************************************
 *the project desc: mvp 基础类 fragment
 *this name is BaseMvpFragment
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年01月31日 11:02:26
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
abstract class BaseMvpFragment<T : ViewBinding,V : ITopView,P:ITopPresenter> : BaseFragment<T>(),IView<P> {


    override fun getCtx()= mContext



    override fun onAttach(context: Context) {
        super.onAttach(context)
        initEnd()

    }

    override fun finish(resultCode: Int) {

    }

    override fun showToast(message: String) {
        getCtx()?.let { Toasty.info(it,message, Toast.LENGTH_SHORT).show() }
    }

    override fun showToast(messageId: Int) {
        getCtx()?.let { Toasty.info(it,messageId,Toast.LENGTH_SHORT).show() }
    }

    override fun showLoading(isTimer: Boolean) {
        if (isTimer){
            showProgressDialogTimeOut("")
        }else{
            showProgressDialog("")
        }
    }

    override fun showLoading(msg: String, isTimer: Boolean) {
        if (isTimer){
            showProgressDialogTimeOut(msg)
        }else{
            showProgressDialog(msg)
        }
    }

    override fun showLoading(msgId: Int, isTimer: Boolean) {
        val msg = resources.getString(msgId)
        if (isTimer){
            showProgressDialogTimeOut(msg)
        }else{
            showProgressDialog(msg)
        }
    }

    override fun dismissLoading() {
        dismissProgressDialog()
    }


}