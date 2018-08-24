package com.rebecca.lib.dialog.fragment

import android.content.DialogInterface
import android.content.DialogInterface.OnDismissListener
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rebecca.lib.zbase.ICreate

abstract class BaseKtDialogFragment : DialogFragment(), ICreate {
    //=========================  =================================
    val mTag = javaClass.simpleName
    var isDebug = false
    //=========================  =================================
    var mRootView: View? = null

    //=========================  =================================

    //========================= init  =================================
    override fun onInit() {
        onInitView()
        onInitData()
    }

    override fun onInitData() {
    }

    override fun onInitView() {
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        onInit()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onDismiss(dialog: DialogInterface?) {
        super.onDismiss(dialog)
        if (activity is OnDismissListener) {
            val listener = activity as OnDismissListener
            listener.onDismiss(dialog)
        }
    }
}