package com.rebecca.lib.zbase.activity

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import com.rebecca.lib.zbase.vm.BaseVM

abstract class BaseVMActivity<VDB : ViewDataBinding, VM : BaseVM> : BaseDMActivity() {
  //=========================  =================================
  lateinit var ui: VDB
  lateinit var vm: VM
  //=========================  =================================
  //=========================  =================================

  //=========================init  =================================
  fun createVM(modelClass: Class<VM>): VM {
    vm = ViewModelProviders.of(this).get(modelClass)
    return onCreateVM(vm)
  }

  open fun onCreateVM(vm: VM): VM {
    return vm
  }

  override fun onDestroyVM() {
    vm.onDestroy()
  }

  override fun onInit() {
    ui = DataBindingUtil.setContentView(this, mLayoutId)
    ui.setLifecycleOwner(this)
    super.onInit()
  }

  override fun onDestroy() {
    if (::vm.isInitialized) {
      onDestroyVM()
    }
    super.onDestroy()
  }
}