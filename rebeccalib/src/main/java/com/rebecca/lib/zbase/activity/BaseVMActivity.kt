package com.rebecca.lib.zbase.activity

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import com.rebecca.lib.zbase.vm.BaseVM

abstract class BaseVMActivity<VDB : ViewDataBinding, VM : BaseVM> : BaseDMActivity() {
  //=========================  =================================
//  open var classVM = ToolsVM.createClassVM<VM>(this)
  protected lateinit var ui: VDB
  protected lateinit var vm: VM
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

  open fun onDestroyVM() {
//    if (::vm.isInitialized) {
    vm.onDestroy()
//    }
  }

  override fun onInit() {
    ui = DataBindingUtil.setContentView(this, mLayoutId)
    ui.setLifecycleOwner(this)
    super.onInit()
  }

  override fun onDestroy() {
    onDestroyVM()
    super.onDestroy()
  }

}