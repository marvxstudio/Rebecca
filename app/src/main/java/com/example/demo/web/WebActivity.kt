package com.example.demo.web

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.demo.R
import com.example.demo.databinding.WebActivityBinding
import com.example.demo.router.RouterUrl
import com.rebecca.lib.web.BaseWebCtr
import com.rebecca.lib.web.BaseWebVMActivity
import com.rebecca.lib.web.IWebCtr
import com.rebecca.lib.zbase.vm.BaseKtVM

@Route(path = RouterUrl.App.Web)
class WebActivity(override var mLayoutId: Int = R.layout.web_activity) : BaseWebVMActivity<WebActivityBinding, BaseKtVM>() {
  //=========================  =================================

  override val classVM: Class<BaseKtVM> = BaseKtVM::class.java
  private val url by lazy {
    "https://www.cnblogs.com/tinyphp/p/3858997.html"
    "https://www.baidu.com"
  }
  //=========================  =================================

  override fun onCreateWeber(): IWebCtr {
    return BaseWebCtr().update(ui.web)
  }
  //========================= init  =================================

  override fun onInitView() {
    super.onInitView()
    webCtr.open(url)
  }
  //========================= main ==================================

}

