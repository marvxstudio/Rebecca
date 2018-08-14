package com.rebecca.lib.v.rv

import android.arch.lifecycle.ViewModel
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View

abstract class BaseRvVH<VDB : ViewDataBinding, VM : ViewModel>(v: View) : ViewHolder(v) {

    //=========================  =================================
    protected lateinit var vm: VM
    lateinit var ui: VDB
    //=========================  =================================
    open protected fun onUpdateVM(vm: VM) {
    }

    fun updateVM(vm: VM) {
        this.vm = vm
        onUpdateVM(vm)
    }

    //========================= init  =================================
    init {
        ui = DataBindingUtil.bind(v)!!
    }
    //========================= main ==================================

}