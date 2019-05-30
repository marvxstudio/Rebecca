package com.rebecca.lib.web

import android.databinding.ViewDataBinding
import com.rebecca.lib.zbase.activity.BaseVMActivity
import com.rebecca.lib.zbase.vm.BaseVM

abstract class BaseWebVMActivity<VDB : ViewDataBinding, VM : BaseVM> : BaseVMActivity<VDB, VM>() {
  //=========================  =================================

  //=========================  =================================
  protected val weber by lazy { onCreateWeber() }

  abstract fun onCreateWeber(): BaseWeber
  //========================= init  =================================

  //========================= main ==================================

}