package com.rebecca.lib.zbase.activity

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding

abstract class BaseVMActivity<VDB : ViewDataBinding, VM : ViewModel> : BaseDMActivity() {
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

    override fun onInit() {
        ui = DataBindingUtil.setContentView(this, mLayoutId)
        ui.setLifecycleOwner(this)
        super.onInit()
    }

    //=========================main ==================================
}