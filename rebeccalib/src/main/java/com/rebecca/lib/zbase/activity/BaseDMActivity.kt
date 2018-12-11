package com.rebecca.lib.zbase.activity

import android.content.DialogInterface
import android.content.DialogInterface.OnDismissListener
import android.support.v4.app.DialogFragment
import com.rebecca.lib.dialog.IDialogManager
import com.rebecca.lib.zbase.DialogManager

abstract class BaseDMActivity : BaseKtActivity(), OnDismissListener {

    //====================================================
    val dialogManager: IDialogManager<DialogFragment> by lazy { onCreateDialogManager() }

    //====================================================

    open fun onCreateDialogManager(): IDialogManager<DialogFragment> {
        return DialogManager(supportFragmentManager)
    }
    //======================= init =============================

    //======================= main =============================
    override fun onDismiss(dialog: DialogInterface?) {
        dialogManager.onDismiss(dialog)
    }

    override fun onStart() {
        super.onStart()
        dialogManager.onStart()
    }

    override fun onDestroy() {
        dialogManager.onDestroy()
        super.onDestroy()
    }
}