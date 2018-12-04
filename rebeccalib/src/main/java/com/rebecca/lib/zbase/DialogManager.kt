package com.rebecca.lib.zbase

import android.content.DialogInterface
import android.content.DialogInterface.OnDismissListener
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager

open class DialogManager<DF : DialogFragment>(var fm: FragmentManager) : OnDismissListener {

    val dialogList: ArrayList<DF> by lazy { ArrayList<DF>() }

    //=================================================
    private var isLive = true
    //=================================================

    var mDialog: DF? = null
    //=================================================

    //=================================================
    fun add(dialog: DF) {
        if (isLive) {
            onAddDialog(dialog)
            createDialog()
        }
    }

    protected open fun onAddDialog(dialog: DF) {
        dialogList.add(dialog)
    }

    protected fun createDialog() {
        if (isLive && mDialog == null && dialogList.size > 0) {

            mDialog = dialogList.get(0)
            dialogList.removeAt(0)

            try {
                mDialog?.show(fm, "dialog")
            }
            catch (e: Exception) {
                mDialog = null
                createDialog()
            }
        }
    }

    override fun onDismiss(dialog: DialogInterface?) {
        mDialog = null
        createDialog()
    }

    //================================
    fun start() {
        isLive = true
        createDialog()
    }

    fun destroy() {
        isLive = false
        dialogList.clear()
        val dialog = mDialog
        if (dialog != null && dialog.isAdded) {
            dialog.dismiss()
        }
    }
    //================================

}