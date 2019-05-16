package com.rebecca.lib.web

import android.databinding.ViewDataBinding
import com.rebecca.lib.zbase.activity.BaseVMActivity
import com.rebecca.lib.zbase.vm.BaseVM

abstract class BaseWebVMActivity<VDB : ViewDataBinding, VM : BaseVM> : BaseVMActivity<VDB, VM>() {
  //=========================  =================================

  //=========================  =================================

  abstract fun onCreateWeb()
  //========================= init  =================================

  override fun onInitView() {
    super.onInitView()
    onCreateWeb()
  }
  //========================= main ==================================

}