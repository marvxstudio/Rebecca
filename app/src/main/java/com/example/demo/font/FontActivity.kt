package com.example.demo.font

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.demo.R
import com.example.demo.databinding.FontActivityBinding
import com.example.demo.router.RouterUrl
import com.example.demo.zbase.Clicker
import com.rebecca.lib.tools.Loger
import com.rebecca.lib.zbase.activity.BaseVMActivity

@Route(path = RouterUrl.App.Font)
class FontActivity(override var mLayoutId: Int = R.layout.font_activity) : BaseVMActivity<FontActivityBinding, FontVM>(), Clicker {
  //=========================  =================================
  var i = 0

  override fun onClick(v: View?) {
    val coun = i++
    //vm.bean.value = BeanTest(coun.toString()).also { it.k.value = coun.toString() }

    vm.bean.value?.let {
      it.name = coun.toString()
      it.k.value = coun.toString()
    }
    vm.bean.value?.let {
      Loger.show(it.k.value + "  " + it.name)
    }

  }
  //=========================  =================================

  //========================= init  =================================

  override fun onInitView() {
    super.onInitView()
    ui.vm = createVM(FontVM::class.java)
    ui.clicker = this
  }
  //========================= main ==================================
}