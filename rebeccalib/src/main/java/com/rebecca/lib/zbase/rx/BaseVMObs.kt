package com.rebecca.lib.zbase.rx

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

interface BaseVMObs<B : Any> : Observer<B> {

    //===========================================

    //===========================================
    fun onRec(b: B)

    fun isRec(b: B): Boolean
    //===========================================
    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(b: B) {
        if (isRec(b)) {
            onRec(b)
        }
    }

    override fun onError(e: Throwable) {
    }

    //===========================================

}