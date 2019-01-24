package com.rebecca.lib.http.rx.base

interface IRec<BOX : Any> {

    //=================== ========================

    //=================== ========================

    //=================== ========================
    fun isRec(box: BOX): Boolean

    fun onRec(box: BOX)

    //=================== ========================

    //=================== error ======================

    fun onError(box: BOX) {}

    fun onErrorNetON(e: Throwable) {}

    fun onErrorNetOFF(e: Throwable) {}
    //=================== ========================

    //===========================================

    fun isNetOn(): Boolean
}