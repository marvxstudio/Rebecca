package com.rebecca.lib.zbase.fragment

import android.support.v4.app.DialogFragment
import com.rebecca.lib.dialog.IDialogManager
import com.rebecca.lib.zbase.activity.BaseDMActivity

abstract class BaseDMFragment : BaseKtFragment() {

    //=========================  =================================
    var dialogManager: IDialogManager<DialogFragment>? = null

    //=========================  =================================
    protected fun initDialogManager() {
        if (activity is BaseDMActivity) {
            dialogManager = (activity as BaseDMActivity).dialogManager
        }
    }

    override fun onInitView() {
        super.onInitView()
        initDialogManager()
    }
    //========================= main ==================================
}