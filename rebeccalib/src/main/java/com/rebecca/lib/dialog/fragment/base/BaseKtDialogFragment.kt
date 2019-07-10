package com.rebecca.lib.dialog.fragment.base

import android.app.Dialog
import android.content.DialogInterface
import android.content.DialogInterface.OnDismissListener
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.rebecca.lib.dialog.IDialogCanceClicker
import com.rebecca.lib.dialog.IDialogEnterClicker
import com.rebecca.lib.zbase.ICreate

abstract class BaseKtDialogFragment : DialogFragment(), ICreate {
  //=========================  =================================
  val mTag = javaClass.simpleName
  open var isDebug = false
  //=========================  =================================
  open var openTitle = true

  open var openBackground = true

  open var openTouchOutside = true

  open var widthPCT = 0.75
  //=========================  =================================
  var mRootView: View? = null

  var clickerCancel: IDialogCanceClicker? = null

  var clickerEnter: IDialogEnterClicker? = null
  //=========================  =================================
  //=========================  =================================
  open fun onInitDialog() {
    if (openTitle == false) {
      dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    }
    if (openBackground == false) {
      dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
    dialog.setCanceledOnTouchOutside(openTouchOutside)
  }

  open fun onInitWindow(dialog: Dialog? = this.dialog, window: Window? = dialog?.window) {
    window?.let {
      if (openTitle == false) {
        val dm = DisplayMetrics()
        activity?.windowManager?.defaultDisplay?.getMetrics(dm)
        val width: Int = (dm.widthPixels * widthPCT).toInt()
        it.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
      }
    }
  }

  //=========================  =================================
  fun add(clicker: IDialogEnterClicker?): BaseKtDialogFragment {
    clickerEnter = clicker
    return this
  }

  fun add(clicker: IDialogCanceClicker?): BaseKtDialogFragment {
    clickerCancel = clicker
    return this
  }

  //========================= init  =================================
  override fun onInit() {
    onInitView()
    onInitData()
  }

  override fun onInitData() {
  }

  override fun onInitView() {
    onInitDialog()
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

  //========================= main ==================================
  override fun onStart() {
    super.onStart()
    onInitWindow()
  }

}