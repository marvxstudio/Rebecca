package com.rebecca.lib.zbase.fragment

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseVMFragment<VDB : ViewDataBinding, VM : ViewModel> : BaseLazyFragment() {
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

    override fun onCreateRootView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        ui = DataBindingUtil.inflate(inflater, mLayoutId, container, false)
        ui.setLifecycleOwner(this)
        return ui.root
    }

    //=========================main ==================================
}