package com.rebecca.lib.zbase.service

import android.app.Service

abstract class BaseKtService : Service() {

    val mTag = javaClass.simpleName

    open var isDebug = false
}