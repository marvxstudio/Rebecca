package com.rebecca.lib.zbase.fragment

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rebecca.lib.zbase.vm.BaseVM

abstract class BaseVMFragment<VDB : ViewDataBinding, VM : BaseVM> : BaseLazyFragment() {
  //=========================  =================================
  protected lateinit var ui: VDB
  //=========================  =================================
  protected abstract val classVM: Class<VM>
  val vm: VM by lazy { createVM() }

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

  override fun onCreateRootView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    ui = DataBindingUtil.inflate(inflater, mLayoutId, container, false)
    ui.setLifecycleOwner(this)
    return ui.root
  }

  override fun onDestroy() {
    onDestroyVM(this)
    super.onDestroy()
  }
}