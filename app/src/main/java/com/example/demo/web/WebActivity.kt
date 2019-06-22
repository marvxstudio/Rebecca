package com.example.demo.web

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.demo.R
import com.example.demo.databinding.WebActivityBinding
import com.example.demo.router.RouterUrl
import com.example.demo.web.itf.RebeccaWeber
import com.rebecca.lib.web.BaseWebVMActivity
import com.rebecca.lib.web.BaseWeber
import com.rebecca.lib.zbase.vm.BaseVM

@Route(path = RouterUrl.App.Web)
class WebActivity(override var mLayoutId: Int = R.layout.web_activity) : BaseWebVMActivity<WebActivityBinding, BaseVM>() {
  //=========================  =================================

  override val classVM: Class<BaseVM> = BaseVM::class.java
  val url = "https://www.baidu.com"//"https://www.cnblogs.com/tinyphp/p/3858997.html" //"www.baidu.com"

  //=========================  =================================

  override fun onCreateWeber(): BaseWeber {
    return RebeccaWeber().update(ui.web)
  }

  //========================= init  =================================

  override fun onInitView() {
    super.onInitView()
    weber.open(url)
  }
  //========================= main ==================================

}