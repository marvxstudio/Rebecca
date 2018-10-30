package com.example.demo.list.fragment

import com.example.demo.R
import com.example.demo.databinding.FunListFragmentBinding
import com.example.demo.list.fragment.rv.FunListAdapter
import com.rebecca.lib.zbase.fragment.BaseVMFragment

class FunListFragment : BaseVMFragment<FunListFragmentBinding, FunListVM>() {
    override var mLayoutId: Int = R.layout.fun_list_fragment
    //=========================  =================================
    //========================= rv =================================

    fun initRV() {
        val adapter = FunListAdapter()
        vm.createList(activity!!, adapter)
        ui.rv.adapter = adapter
        adapter.updateLayoutManager(activity!!, ui.rv)
        adapter.update(vm.funList)
    }
    //========================= init  =================================

    override fun onCreateVM(vm: FunListVM): FunListVM {

        return super.onCreateVM(vm)
    }

    override fun onInitView() {
        super.onInitView()
        ui.vm = createVM(FunListVM::class.java)
        initRV()
    }
    //========================= main ==================================
}