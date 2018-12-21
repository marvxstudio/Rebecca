package com.rebecca.lib.dialog.manager

import android.content.DialogInterface
import android.content.DialogInterface.OnDismissListener
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import com.rebecca.lib.dialog.IDialogManager

open class BaseDialogManager<DF : DialogFragment>(var fm: FragmentManager) : OnDismissListener, IDialogManager<DF> {

    val dialogList: ArrayList<DF> by lazy { ArrayList<DF>() }

    //=================================================
    private var isLive = true
    //=================================================

    var mDialog: DF? = null
    //=================================================

    //=================================================
    override fun add(dialog: DF) {
        if (isLive) {
            onAddDialog(dialog)
            output()
        }
    }

    protected open fun onAddDialog(dialog: DF) {
        dialogList.add(dialog)
    }

    override fun output() {
        if (isLive && mDialog == null && dialogList.isNotEmpty()) {

            mDialog = dialogList.get(0)
            dialogList.removeAt(0)

            try {
                mDialog?.show(fm, "dialog")
            }
            catch (e: Exception) {
                mDialog = null
                output()
            }
        }
    }

    override fun onDismiss(dialog: DialogInterface?) {
        mDialog = null
        output()
    }

    override fun onStart() {
        isLive = true
        output()
    }

    override fun onDestroy() {
        isLive = false
        dialogList.clear()
    }
    //================================

}