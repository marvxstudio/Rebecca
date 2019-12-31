package com.rebecca.lib.zbase.activity

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import com.rebecca.lib.zbase.vm.BaseKtVM

abstract class BaseVMActivity<VDB : ViewDataBinding, VM : BaseKtVM> : BaseDMActivity() {
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
    vm.onCreate(this)
    return vm
  }

  override fun onDestroyVM(owner: LifecycleOwner) {
    vm.onDestroy(owner)
  }

  override fun onInit() {
    ui = DataBindingUtil.setContentView(this, mLayoutId)
    ui.setLifecycleOwner(this)
    super.onInit()
  }

  override fun onDestroy() {
    onDestroyVM(this)
    super.onDestroy()
  }
}