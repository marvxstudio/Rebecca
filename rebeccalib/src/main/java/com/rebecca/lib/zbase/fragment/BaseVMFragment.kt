package com.rebecca.lib.zbase.fragment

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rebecca.lib.tools.ToolsVM
import com.rebecca.lib.zbase.vm.BaseVM

abstract class BaseVMFragment<VDB : ViewDataBinding, VM : BaseVM> : BaseLazyFragment() {
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

  override fun onCreateRootView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    ui = DataBindingUtil.inflate(inflater, mLayoutId, container, false)
    ui.setLifecycleOwner(this)
    return ui.root
  }

  override fun onDestroy() {
    onDestroyVM()
    super.onDestroy()
  }
}