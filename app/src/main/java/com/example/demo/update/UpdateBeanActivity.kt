package com.example.demo.update

import android.view.View
import com.example.demo.R
import com.example.demo.bean.BeanTest
import com.example.demo.databinding.UpdateBeanActivityBinding
import com.example.demo.zbase.Clicker
import com.rebecca.lib.zbase.activity.BaseVMActivity

class UpdateBeanActivity(override var mLayoutId: Int = R.layout.update_bean_activity) : BaseVMActivity<UpdateBeanActivityBinding, UpdateBeanVM>(), Clicker {

  //=========================  =================================
  override val classVM: Class<UpdateBeanVM> = UpdateBeanVM::class.java
  //=========================  =================================
  var count = 0
  //=========================  =================================

  override fun onClick(v: View?) {
    when (v) {
      ui.bt1 -> {
        vm.bean.set(BeanTest())
      }
      ui.bt2 -> {
        vm.bean.get()?.let {
          count++
          it.text.set(count.toString())
        }
      }
      ui.bt3 -> {
        ui.vm = vm
      }
      ui.tvCount -> {

      }
    }
  }
  //=========================  =================================

  //========================= init  =================================

  override fun onInitView() {
    super.onInitView()
    ui.clicker = this
    ui.vm = vm
  }
  //========================= main ==================================

}