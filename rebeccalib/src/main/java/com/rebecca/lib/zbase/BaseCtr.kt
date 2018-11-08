package com.rebecca.lib.zbase

abstract class BaseCtr {

    val mTag = javaClass.simpleName

    open var isDebug = false

    //==============================
    fun setDebug(debug: Boolean): BaseCtr {
        isDebug = debug

        return this
    }
}