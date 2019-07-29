package com.rebecca.lib.zbase.application

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.rebecca.lib.tools.ToolsApp
import com.rebecca.lib.tools.Loger

open class BaseVMApplication : Application() {

  //=========================  =================================
  val isAppDebug: Boolean by lazy { ToolsApp.isAppDebug(this) }
  //=========================  =================================
  open var openRouter = false
  open var openRouterDebug = false

  //========================= router  =================================
  protected open fun initRouter(isOpen: Boolean = openRouter, isDebug: Boolean = openRouterDebug) {
    if (isOpen) {
      ARouter.init(this)
    }
    if (isDebug) {
      ARouter.openLog()
    }
  }
  //=========================  =================================

  //========================= init  =================================

  //========================= main ==================================

  override fun onCreate() {
    super.onCreate()
    Loger.isOpen = isAppDebug
    initRouter()
  }
}