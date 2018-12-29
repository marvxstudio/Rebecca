package com.rebecca.lib.dialog.fragment.base

import android.content.DialogInterface
import android.content.DialogInterface.OnDismissListener
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rebecca.lib.dialog.IDialogCanceClicker
import com.rebecca.lib.dialog.IDialogEnterClicker
import com.rebecca.lib.zbase.ICreate

abstract class BaseKtDialogFragment : DialogFragment(), ICreate {
    //=========================  =================================
    val mTag = javaClass.simpleName
    open var isDebug = false
    //=========================  =================================
    var mRootView: View? = null

    var clickerCancel: IDialogCanceClicker? = null

    var clickerEnter: IDialogEnterClicker? = null
    //========================= init  =================================
    override fun onInit() {
        onInitView()
        onInitData()
    }

    override fun onInitData() {
    }

    override fun onInitView() {
    }

    open fun createRootView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mRootView = createRootView(inflater, container, savedInstanceState)
        onInit()
        return mRootView
    }

    override fun onDismiss(dialog: DialogInterface?) {
        super.onDismiss(dialog)
        if (activity is OnDismissListener) {
            val listener = activity as OnDismissListener
            listener.onDismiss(dialog)
        }
    }

    //=========================  =================================
    fun add(clicker: IDialogEnterClicker): BaseKtDialogFragment {
        clickerEnter = clicker
        return this
    }

    fun add(clicker: IDialogCanceClicker): BaseKtDialogFragment {
        clickerCancel = clicker
        return this
    }
}