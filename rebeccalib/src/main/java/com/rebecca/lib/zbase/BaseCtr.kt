package com.rebecca.lib.zbase

abstract class BaseCtr {

    val mTag = javaClass.simpleName

    var isDebug = false

    //==============================
    fun setDebug(debug: Boolean): BaseCtr {
        isDebug = debug

        return this
    }
}