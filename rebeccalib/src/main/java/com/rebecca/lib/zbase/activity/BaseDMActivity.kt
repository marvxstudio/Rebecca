package com.rebecca.lib.zbase.activity

import android.content.DialogInterface
import android.content.DialogInterface.OnDismissListener
import android.support.v4.app.DialogFragment
import com.rebecca.lib.zbase.DialogManager

abstract class BaseDMActivity : BaseKtActivity(), OnDismissListener {

    //====================================================
    val dialogManager: DialogManager<DialogFragment> by lazy { DialogManager<DialogFragment>(supportFragmentManager) }

    //====================================================

    //======================= init =============================

    //======================= main =============================
    override fun onDismiss(dialog: DialogInterface?) {
        dialogManager.onDismiss(dialog)
    }

    override fun onStart() {
        super.onStart()
        dialogManager.start()
    }

    override fun onDestroy() {
        dialogManager.destroy()
        super.onDestroy()
    }
}