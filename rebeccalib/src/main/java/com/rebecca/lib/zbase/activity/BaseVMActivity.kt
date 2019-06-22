package com.rebecca.lib.zbase.activity

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import com.rebecca.lib.zbase.vm.BaseVM

abstract class BaseVMActivity<VDB : ViewDataBinding, VM : BaseVM> : BaseDMActivity() {
  //=========================  =================================
  protected lateinit var ui: VDB
  //=========================  =================================
  protected abstract val classVM: Class<VM>
  val vm: VM by lazy { createVM() }
  //=========================  =================================
  //=========================  =================================

  //=========================init  =================================
  protected fun createVM(modelClass: Class<VM> = classVM): VM {
    val vm = ViewModelProviders.of(this).get(modelClass)
    return onCreateVM(vm)
  }

  protected open fun onCreateVM(vm: VM): VM {
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
    //if (::vm.isInitialized) {
    onDestroyVM()
    //}
    super.onDestroy()
  }
}