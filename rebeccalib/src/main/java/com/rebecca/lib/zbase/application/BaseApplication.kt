package com.rebecca.lib.zbase.application

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

open class BaseApplication : Application() {

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
    //========================= init  =================================

    //========================= main ==================================

    override fun onCreate() {
        super.onCreate()
        initRouter()
    }
}