package com.example.demo.permit

import com.example.demo.R
import com.example.demo.databinding.PermitActivityBinding
import com.example.demo.permit.rv.PermitAdapter
import com.example.demo.permit.rv.PermitItemVM
import com.rebecca.lib.tools.Loger
import com.rebecca.lib.tools.Toaster
import com.rebecca.lib.tools.ToolsPermit
import com.rebecca.lib.zbase.activity.BaseVMActivity

class PermitActivity(override var mLayoutId: Int = R.layout.permit_activity) : BaseVMActivity<PermitActivityBinding, PermitVM>() {
  //=========================  =================================

  override val classVM: Class<PermitVM> = PermitVM::class.java
  //=========================  =================================
  protected val adapter by lazy { PermitAdapter(vm.list) }
  val toaster by lazy { Toaster(this) }
  //=========================  =================================

  //========================= init  =================================

  override fun onCreateVM(vm: PermitVM): PermitVM {

    vm.watcher = object : PermitItemVM.Watcher {
      override fun onCheck(pm: String) {
        val context = this@PermitActivity
        Loger.show("""=
      |${pm}
      |${ToolsPermit.isPermit(context, pm)}
      |${ToolsPermit.canPermitRequest(context, pm)}
    """)
      }

      override fun onOpen(vararg pmList: String) {
        ToolsPermit.open(this@PermitActivity, pmList = *pmList)
        pmList.forEach {
          ToolsPermit.open(this@PermitActivity, it, {
            "$it = ✔".let {
              toaster.show(it)
              Loger.show(it)
            }
          })
        }
      }
    }
    vm.createList()
    return super.onCreateVM(vm)
  }

  override fun onInitView() {
    super.onInitView()
    ui.vm = vm
    adapter.update(this, ui.rv)
  }
  //========================= main ==================================

}