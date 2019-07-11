package com.example.demo.dialog.fragment

import android.view.View
import com.example.demo.R
import com.example.demo.databinding.MaterialDialogFragmentBinding
import com.example.demo.dialog.vm.MaterialDialogVM
import com.example.demo.zbase.Clicker
import com.rebecca.lib.dialog.fragment.BaseVMDialogFragment
import com.rebecca.lib.tools.Loger

class MaterialDialogFragment : BaseVMDialogFragment<MaterialDialogFragmentBinding, MaterialDialogVM>(), Clicker {
  //=========================  =================================
  var age = 0
  override val classVM: Class<MaterialDialogVM> = MaterialDialogVM::class.java
  override var mLayoutId: Int = R.layout.material_dialog_fragment
  //=========================  =================================

  //=========================  =================================
  override fun onClick(v: View?) {
    when (v) {
      ui.btApply -> {
        age++
        vm.age = age.toString()

        vm.info.postValue(" age:" + vm.age)
        dialogManager?.add(MaterialDialogFragment())
      }
      ui.tvClose -> {
        dismiss()
      }
    }
  }
  //=========================  =================================

  //========================= init =================================

  override fun onCreateVM(vm: MaterialDialogVM): MaterialDialogVM {
    vm.title.value = "自定义标题"
    vm.info.postValue("信息")
    return super.onCreateVM(vm)
  }

  override fun onInitView() {
    super.onInitView()

    ui.vm = createVM(MaterialDialogVM::class.java)
    ui.clicker = this
    dialog.setTitle(vm.title.value)
    Loger.show("dialog init")
  }

  //========================= main ==================================

}