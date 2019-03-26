package com.example.demo.font

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.demo.R
import com.example.demo.databinding.FontActivityBinding
import com.example.demo.router.RouterUrl
import com.rebecca.lib.zbase.activity.BaseVMActivity

@Route(path = RouterUrl.App.Font)
class FontActivity(override var mLayoutId: Int = R.layout.font_activity) : BaseVMActivity<FontActivityBinding, FontVM>() {
  //=========================  =================================

  //=========================  =================================

  //========================= init  =================================

  override fun onInitView() {
    super.onInitView()
    ui.vm = createVM(FontVM::class.java)
  }
  //========================= main ==================================
}