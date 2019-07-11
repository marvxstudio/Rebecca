package com.rebecca.lib.dialog.fragment.base

import android.content.DialogInterface
import android.content.DialogInterface.OnDismissListener
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.util.DisplayMetrics
import android.view.*
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

  open var widthPCT = 0.75f
  open var heightPCT = -1f
  open var gravity = Gravity.CENTER
  //=========================  =================================
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

  open fun onInitWindow(window: Window? = dialog?.window) {
    window?.let {
      if (openTitle == false) {
        val dm = DisplayMetrics()
        activity?.windowManager?.defaultDisplay?.getMetrics(dm)
        val w = if (widthPCT in 0f..1f) (dm.widthPixels * widthPCT).toInt() else ViewGroup.LayoutParams.WRAP_CONTENT
        val h = if (heightPCT in 0f..1f) (dm.heightPixels * heightPCT).toInt() else ViewGroup.LayoutParams.WRAP_CONTENT

        onUpdateWindowSize(w, h, window = it)
      }
    }
  }

  open fun onUpdateWindowSize(w: Int, h: Int, gravity: Int = this.gravity, window: Window? = dialog?.window) {
    window?.let {
      it.setGravity(gravity)
      it.setLayout(w, h)
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

  open fun onCreateRootView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

    return null
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

    return onCreateRootView(inflater, container, savedInstanceState)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    onInit()
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