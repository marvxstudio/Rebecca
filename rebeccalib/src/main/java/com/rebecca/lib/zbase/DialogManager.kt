package com.rebecca.lib.zbase

import android.content.DialogInterface
import android.content.DialogInterface.OnDismissListener
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager

open class DialogManager<DF : DialogFragment>(var fm: FragmentManager) : OnDismissListener {

    val dialogList: ArrayList<DF> by lazy { ArrayList<DF>() }

    //=================================================

    var mDialog: DF? = null
    //=================================================
    fun add(dialog: DF) {
        onAddDialog(dialog)
        createDialog()
    }

    protected open fun onAddDialog(dialog: DF) {
        dialogList.add(dialog)
    }

    protected fun createDialog() {
        if (mDialog == null && dialogList.size > 0) {

            mDialog = dialogList.get(0)
            dialogList.removeAt(0)
            mDialog?.show(fm, "dialog")
        }
    }

    override fun onDismiss(dialog: DialogInterface?) {
        mDialog = null
        createDialog()
    }

    //================================

    //================================

}