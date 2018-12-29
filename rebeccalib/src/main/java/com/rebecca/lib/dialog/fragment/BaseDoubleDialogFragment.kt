package com.rebecca.lib.dialog.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import com.rebecca.lib.dialog.fragment.base.BaseKtDialogFragment

open class BaseDoubleDialogFragment : BaseKtDialogFragment() {
    //=========================  =================================
    var title: String = ""
    var msg: String = ""
    var textEnter: String = ""
    var textCancel: String = ""
    //=========================  =================================


    //=========================  =================================
    open var outsideCancel = false
    //=========================  =================================

    fun create(msg: String, textEnter: String = "", textCancel: String = "", title: String = ""): BaseDoubleDialogFragment {
        this.title = title
        this.textEnter = textEnter
        this.textCancel = textCancel
        this.msg = msg

        return this
    }

    //==========================================================
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(activity)
                .setMessage(msg).setTitle(title)
                .setPositiveButton(textEnter, clickerEnter)
                .setNegativeButton(textCancel, clickerCancel)

        val dialog = builder.create()
        dialog.setCanceledOnTouchOutside(outsideCancel)
        return dialog
    }

    //=========================  =================================
    fun setOutsideCancel(flag: Boolean): BaseDoubleDialogFragment {
        outsideCancel = flag
        return this
    }

    //=========================  =================================

}