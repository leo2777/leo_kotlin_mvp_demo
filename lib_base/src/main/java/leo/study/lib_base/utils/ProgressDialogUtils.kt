package leo.study.lib_base.utils

import android.app.Dialog
import android.content.Context
import android.text.TextUtils
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.TextView
import leo.study.lib_base.R


/**
 *
 * ***********************************************************************
 *the project desc: 加载框工具类
 *this name is ProgressDialogUtils
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2022年12月16日 14:28:22
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
open class ProgressDialogUtils(context: Context, style: Int) {
    private val timeOut: Long = 3000

    private var dialog: Dialog
    private var contentView: View
    private var tvLoadingDesc: TextView


    init {
        dialog = Dialog(context, style)
        contentView = LayoutInflater.from(context).inflate(R.layout.loading_layout, null)
        tvLoadingDesc = contentView.findViewById(R.id.tv_loading_desc)

        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(contentView)
        var window = dialog.window
        window?.setGravity(Gravity.CENTER)
    }


    /**
     * 显示加载框（无文字）
     */
    private fun showProgressDialog() {
        if (!dialog.isShowing) {
            tvLoadingDesc.visibility = View.VISIBLE
            dialog.show()
        }
    }

    /**
     * 显示显示加载框（无文字）
     */
    private fun showProgressTimeDialog() {
        if (!dialog.isShowing) {
            tvLoadingDesc.visibility = View.VISIBLE
            dialog.show()

            contentView.postDelayed({ dialog.dismiss() }, timeOut)
        }
    }

    /**
     * 显示文字的加载框
     * @param text 显示文本
     */
    open fun showProgressMsgDialog(text: String) {
        if (TextUtils.isEmpty(text)) {
            showProgressDialog()
            return
        }
        if (!dialog.isShowing) {
            tvLoadingDesc.text = text
            tvLoadingDesc.visibility = View.VISIBLE
            dialog.show()
        }
    }

    /**
     * 显示限时文字加载框
     * @param text 显示文本
     */
    open fun showProgressMsgTimeDialog(text: String) {
        if (TextUtils.isEmpty(text)) {
            showProgressTimeDialog()
            return
        }
        if (!dialog.isShowing) {
            tvLoadingDesc.text = text
            tvLoadingDesc.visibility = View.VISIBLE
            dialog.show()

            contentView.postDelayed({ dialog.dismiss() }, timeOut)
        }
    }

    /**
     * 关闭加载框
     */
    open fun dismissProgressDialog(){
        if (dialog.isShowing){
            dialog.dismiss()
        }
    }


}