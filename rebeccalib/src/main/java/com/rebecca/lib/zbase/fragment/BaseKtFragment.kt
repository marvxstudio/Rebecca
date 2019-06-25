package com.rebecca.lib.zbase.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rebecca.lib.zbase.ICreate

abstract class BaseKtFragment : Fragment(), ICreate {
  //=========================  =================================
  protected abstract var mLayoutId: Int
  //=========================  =================================
  val mTag = "${javaClass.simpleName} $id"

  open var isDebug = false
  //=========================  =================================
  var mRootView: View? = null

  open var isTouchThrough = false
  //=========================  =================================
  open fun addTo(id: Int, fm: FragmentManager, canPop: Boolean = false, tag: String = mTag, ft: FragmentTransaction = fm.beginTransaction()) {
    ft.add(id, this, tag)
    if (canPop) {
      ft.addToBackStack(mTag)
    }
    ft.commit()
  }

  open fun pop(fm: FragmentManager, flag: Int = 0) {
//    fm.fragments.let { list ->
//      val index = list.indexOf(this)
//      if (index >= 0) {
//        fm.popBackStack(index, flag)
//      }
//    }
  }

  open fun remove(fm: FragmentManager, ft: FragmentTransaction = fm.beginTransaction()) {
    ft.remove(this).commit()
  }
  //=========================  =================================

  open fun show(ft: FragmentTransaction, isShow: Boolean): FragmentTransaction {
    if (isShow) {
      ft.show(this)
    }
    else {
      ft.hide(this)
    }
    userVisibleHint = isShow
    return ft
  }
  //========================= init =================================

  abstract fun onCreateRootView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View

  override fun onInit() {
    if (isTouchThrough == false) {
      mRootView?.setOnClickListener(null)
    }
    onInitView()
    onInitData()
  }

  override fun onInitView() {
  }

  override fun onInitData() {
  }

  //=========================main ==================================

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    if (mRootView == null) {
      mRootView = onCreateRootView(inflater, container, savedInstanceState)
    }
    else {
      val viewparent = mRootView?.parent
      if (viewparent != null && viewparent is ViewGroup) {
        val vg: ViewGroup? = mRootView?.getParent() as ViewGroup
        vg?.removeView(mRootView)
      }
    }
    return mRootView
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    onInit()
  }
}