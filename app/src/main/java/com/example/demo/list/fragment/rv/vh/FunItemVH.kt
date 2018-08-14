package com.example.demo.list.fragment.rv.vh

import android.view.View
import android.view.ViewGroup
import com.example.demo.R
import com.example.demo.activity.Clicker
import com.example.demo.databinding.FunItemVhBinding
import com.example.demo.list.fragment.rv.FunItemVM
import com.rebecca.lib.tools.ViewTools
import com.rebecca.lib.v.rv.BaseRvVH

class FunItemVH(var vg: ViewGroup) : BaseRvVH<FunItemVhBinding, FunItemVM>(ViewTools.inflate(R.layout.fun_item_vh, vg)),
        Clicker {
//=============================================

    //=============================================
    //=============================================
    override fun onClick(v: View?) {
        when (v) {
            ui.btAction -> {
                vm.start(vg.context)
            }
        }
    }

    override fun onUpdateVM(vm: FunItemVM) {
        ui.vm = vm
    }

    init {
        addCooler(ui.btAction)
    }
}