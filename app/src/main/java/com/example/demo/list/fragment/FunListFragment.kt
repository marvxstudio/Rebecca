package com.example.demo.list.fragment

import android.support.v7.widget.GridLayoutManager
import com.example.demo.R
import com.example.demo.databinding.FunListFragmentBinding
import com.example.demo.list.fragment.rv.FunListAdapter
import com.rebecca.lib.zbase.fragment.BaseVMFragment

class FunListFragment : BaseVMFragment<FunListFragmentBinding, FunListVM>() {
  //=========================  =================================

  override val classVM: Class<FunListVM> = FunListVM::class.java
  override var mLayoutId: Int = R.layout.fun_list_fragment
  //=========================  =================================
  private val adapter by lazy { FunListAdapter(vm.funList) }

//========================= rv =================================

//========================= init  =================================

  override fun onCreateVM(vm: FunListVM): FunListVM {

    return super.onCreateVM(vm)
  }

  override fun onInitView() {
    super.onInitView()
    ui.vm = vm
    adapter.update(activity!!, ui.rv, GridLayoutManager(activity, 10))
    vm.createList()
  }
//========================= main ==================================
}