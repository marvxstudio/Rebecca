package com.example.demo.permit

import android.Manifest.permission
import android.databinding.ObservableArrayList
import com.example.demo.permit.rv.PermitItemVM
import com.rebecca.lib.zbase.vm.BaseKtVM

class PermitVM : BaseKtVM() {

  val list = ObservableArrayList<PermitItemVM>()
  var watcher: PermitItemVM.Watcher? = null
  //================= ===================
  fun createList() {
    list.let {
      it.add(createItem("电话", permission.READ_PHONE_STATE))
      it.add(createItem("摄像头", permission.CAMERA))
      it.add(createItem("混合", permission.READ_PHONE_STATE, permission.CAMERA))
    }
  }

  //================= ===================
  protected fun createItem(name: String, vararg pm: String): PermitItemVM {
    return PermitItemVM().apply {
      pmList = arrayOf(*pm)
      this.name = name
      watcher = this@PermitVM.watcher
    }
  }
}