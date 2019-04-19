package com.example.demo.prove

import android.view.View
import com.example.demo.R
import com.example.demo.databinding.RxActivityBinding
import com.example.demo.zbase.Clicker
import com.rebecca.lib.zbase.activity.BaseVMActivity
import com.rebecca.lib.zbase.vm.BaseVM

class ProveFingerprintActivity(override var mLayoutId: Int = R.layout.rx_activity) : BaseVMActivity<RxActivityBinding, BaseVM>(), Clicker {

  //=========================  =================================

  val pf = ProveFinger(this)
  //=========================  =================================
  override fun onClick(v: View?) {
    when (v) {
      ui.bg, ui.tvTitle -> {
        pf.start()
      }
    }
  }

  //=========================  =================================

  //=========================  =================================

  //========================= init  =================================

  override fun onCreateVM(vm: BaseVM): BaseVM {
    return super.onCreateVM(vm)
  }

  override fun onInitView() {
    super.onInitView()
    ui.clicker = this

  }
  //========================= main ==================================

}