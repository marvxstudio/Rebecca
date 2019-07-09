package com.rebecca.lib.v.rv.vh

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.view.ViewGroup
import com.rebecca.lib.v.rv.BaseRvVM

abstract class BaseRvVH<VDB : ViewDataBinding, VM : BaseRvVM>(vg: ViewGroup, id: Int) : BaseKtVH(vg, id) {

  //=========================  =================================
  protected lateinit var vm: VM
  var ui: VDB
  //=========================  =================================

  //=========================  =================================

  //=========================  =================================
  open protected fun onUpdateVM(vm: VM) {
  }

  override fun updateData(any: Any) {
    (any as VM).let {
      this.vm = it
      onUpdateVM(it)
    }
  }

  //========================= init  =================================
  init {
    ui = DataBindingUtil.bind(itemView)!!
  }
  //========================= main ==================================

}