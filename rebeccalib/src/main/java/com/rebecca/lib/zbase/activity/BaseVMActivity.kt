package com.rebecca.lib.zbase.activity

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import com.rebecca.lib.tools.ToolsVM
import com.rebecca.lib.zbase.vm.BaseVM

abstract class BaseVMActivity<VDB : ViewDataBinding, VM : BaseVM> : BaseDMActivity() {
  //=========================  =================================
  open val classVM = ToolsVM.createClassVM<VM>(this)
  protected lateinit var ui: VDB
  protected val vm: VM by lazy { createVM() }
  //=========================  =================================
  //=========================  =================================

  //=========================init  =================================
  fun createVM(modelClass: Class<VM> = classVM): VM {
    val vm = ViewModelProviders.of(this).get(modelClass)

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