package com.rebecca.lib.v.rv.vh

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.ViewGroup
import com.rebecca.lib.tools.ViewTools
import com.rebecca.lib.v.rv.BaseRvVM
import com.rebecca.lib.v.rv.adapter.BaseKtAdapter

abstract class BaseRvVH<VDB : ViewDataBinding, VM : BaseRvVM>(vg: ViewGroup, id: Int) : ViewHolder(ViewTools.inflate(id, vg)) {

    //=========================  =================================
    protected lateinit var vm: VM
    var ui: VDB
    //=========================  =================================
    lateinit var adapter: BaseKtAdapter<VM>

    //=========================  =================================
    fun set(adapter: BaseKtAdapter<VM>): BaseRvVH<*, VM> {
        this.adapter = adapter
        return this
    }

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