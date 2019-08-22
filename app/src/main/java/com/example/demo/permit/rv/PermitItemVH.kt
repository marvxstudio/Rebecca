package com.example.demo.permit.rv

import android.view.View
import android.view.ViewGroup
import com.example.demo.R
import com.example.demo.databinding.PermitItemVhBinding
import com.example.demo.zbase.Clicker
import com.rebecca.lib.v.rv.vh.BaseRvVH

class PermitItemVH(vg: ViewGroup) : BaseRvVH<PermitItemVhBinding, PermitItemVM>(vg, R.layout.permit_item_vh), Clicker {

  //=================== ================
  override fun onClick(v: View?) {
    when (v) {
      ui.bt -> {

      }
      ui.btCheck -> {
        vm.pmList?.forEach {
          vm.watcher?.onCheck(it)
        }
      }

      ui.btOpen -> {
        vm.pmList?.let {
          vm.watcher?.onOpen(*it)
        }
      }

    }
  }

  //=================== ================
  override fun onUpdateVM(vm: PermitItemVM) {
    super.onUpdateVM(vm)
    ui.vm = vm
    ui.clicker = this
  }

}