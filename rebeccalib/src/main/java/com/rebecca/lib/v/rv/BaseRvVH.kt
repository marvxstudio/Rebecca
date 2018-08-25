package com.rebecca.lib.v.rv

import android.arch.lifecycle.ViewModel
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.ViewGroup
import com.rebecca.lib.tools.ViewTools

abstract class BaseRvVH<VDB : ViewDataBinding, VM : ViewModel>(vg: ViewGroup, id: Int) : ViewHolder(ViewTools.inflate(id, vg)) {

    //=========================  =================================
    protected lateinit var vm: VM
    var ui: VDB
    //=========================  =================================
    open protected fun onUpdateVM(vm: VM) {
    }

    fun updateVM(vm: VM) {
        this.vm = vm
        onUpdateVM(vm)
    }

    //========================= init  =================================
    init {
        ui = DataBindingUtil.bind(itemView)!!
    }
    //========================= main ==================================

}