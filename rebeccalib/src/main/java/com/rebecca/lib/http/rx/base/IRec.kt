package com.rebecca.lib.http.rx.base

interface IRec<BOX : Any> {

    //=================== ========================
    var isRecError: Boolean
    //=================== ========================


    //=================== ========================
    fun isRec(box: BOX): Boolean

    fun onRec(box: BOX)

    //=================== ========================

    fun isRecComplete(isComplete: Boolean = (isRecError == false)): Boolean {
        return isComplete
    }

    fun onRecComplete()

    //=================== error ======================

    fun onError(box: BOX) {}

    fun onErrorNetON(e: Throwable) {}

    fun onErrorNetOFF(e: Throwable) {}
    //=================== ========================
    fun set(isRecError: Boolean) {
        if (isRecError) {
            this.isRecError = isRecError
        }
    }
    //===========================================

    fun isNetOn(): Boolean
}