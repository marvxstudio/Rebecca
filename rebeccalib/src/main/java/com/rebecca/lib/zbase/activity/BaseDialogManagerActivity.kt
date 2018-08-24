package com.rebecca.lib.zbase.activity

import android.arch.lifecycle.ViewModel
import android.content.DialogInterface
import android.content.DialogInterface.OnDismissListener
import android.databinding.ViewDataBinding
import android.support.v4.app.DialogFragment
import com.rebecca.lib.zbase.DialogManager

abstract class BaseDialogManagerActivity<VDB : ViewDataBinding, VM : ViewModel> : BaseVMActivity<VDB, VM>(),
        OnDismissListener {

    //====================================================
    lateinit var dialogManager: DialogManager<DialogFragment>//  by lazy { DialogManager(supportFragmentManager) }

    //====================================================

    //======================= init =============================

    //======================= main =============================
    override fun onDismiss(dialog: DialogInterface?) {
        dialogManager.onDismiss(dialog)
    }

    override fun onDestroy() {
        //dialogManager.onDestory()

        super.onDestroy()
    }
}