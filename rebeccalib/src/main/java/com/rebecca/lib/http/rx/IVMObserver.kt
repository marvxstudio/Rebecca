package com.rebecca.lib.http.rx

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

interface IVMObserver<BOX : Any> : Observer<BOX> {

    //===========================================
    var isRecError: Boolean

    //===========================================

    override fun onSubscribe(d: Disposable) {
    }
    //================== rec ======================

    override fun onNext(box: BOX) {
        if (isRec(box)) {
            onRec(box)
        }
    }

    fun isRec(b: BOX): Boolean

    fun onRec(b: BOX)
    //================ complete ====================
    override fun onComplete() {
        if (isRecComplete()) {
            onRecComplete()
        }
    }

    fun onRecComplete() {
    }

    fun isRecComplete(isComplete: Boolean = (isRecError == false)): Boolean {
        return isComplete
    }

    //===========================================

    fun set(isRecError: Boolean) {
        if (isRecError) {
            this.isRecError = isRecError
        }
    }

    //=============== error ========================
    override fun onError(e: Throwable) {
        if (isNetOn()) {
            onErrorNetON(e)
        }
        else {
            onErrorNetOFF(e)
        }
    }

    fun onError(box: BOX) {
    }

    fun onErrorNetON(e: Throwable) {
    }

    fun onErrorNetOFF(e: Throwable) {
    }
    //===========================================

    fun isNetOn(): Boolean
}