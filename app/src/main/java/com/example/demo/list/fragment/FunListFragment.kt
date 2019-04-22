package com.example.demo.list.fragment

import com.example.demo.R
import com.example.demo.databinding.FunListFragmentBinding
import com.example.demo.list.fragment.rv.FunListAdapter
import com.example.demo.list.fragment.rv.RvVMBox
import com.rebecca.lib.zbase.fragment.BaseVMFragment

class FunListFragment : BaseVMFragment<FunListFragmentBinding, FunListVM>() {
  override var mLayoutId: Int = R.layout.fun_list_fragment
  //=========================  =================================
  private val adapter = FunListAdapter()
  //========================= rv =================================

  fun initRV() {

    adapter.update(activity!!, ui.rv)

  }
  //========================= init  =================================

  override fun onCreateVM(vm: FunListVM): FunListVM {
    vm.watcher = object : FunListVM.Watcher {
      override fun onUpdate(list: ArrayList<RvVMBox>) {
        adapter.update(list)
      }
    }
    return super.onCreateVM(vm)
  }

  override fun onInitView() {
    super.onInitView()
    ui.vm = createVM(FunListVM::class.java)
    initRV()
    vm.createList(adapter)
  }
  //========================= main ==================================
}