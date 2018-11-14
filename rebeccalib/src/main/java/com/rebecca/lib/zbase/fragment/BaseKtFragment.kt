package com.rebecca.lib.zbase.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rebecca.lib.zbase.ICreate

abstract class BaseKtFragment : Fragment(), ICreate {
    //=========================  =================================
    abstract var mLayoutId: Int
    //=========================  =================================
    val mTag = javaClass.simpleName

    var isDebug = false
    //=========================  =================================
    var mRootView: View? = null

    open var isTouchThrough = false
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