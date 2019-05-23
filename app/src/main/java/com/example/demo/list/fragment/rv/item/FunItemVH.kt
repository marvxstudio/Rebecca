package com.example.demo.list.fragment.rv.item

import android.view.View
import android.view.ViewGroup
import com.example.demo.R
import com.example.demo.zbase.Clicker
import com.example.demo.databinding.FunItemVhBinding
import com.example.demo.list.fragment.rv.RvVMBox
import com.rebecca.lib.v.rv.vh.BaseRvVH

class FunItemVH(var vg: ViewGroup) : BaseRvVH<FunItemVhBinding, RvVMBox>(vg, R.layout.fun_item_vh), Clicker {
    //=============================================

    //=============================================
    //=============================================
    override fun onClick(v: View?) {
        when (v) {
            ui.btAction -> {
                //vm.start(vg.context)
                vm.vmItem.onClick()
                vm.vmItem.setName(vm.vmItem.name.get() + "1")
                //adapter.add(RvVMBox().set(ItemStartVM()), isNotify = false)
                //vm.name.set(vm.name.get() + 1)
                //Loger.show("list size= " + adapter.mlist.size + " , " + vm.name.get())
            }
        }
    }

    override fun onUpdateVM(vm: RvVMBox) {
        ui.vm = vm.vmItem
    }

    init {
        addCooler(ui.btAction)
    }
}