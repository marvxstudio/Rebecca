package com.rebecca.lib.http.rx

import io.reactivex.disposables.Disposable

abstract class BaseVMObs<BOX : Any> : IVMObserver<BOX> {

    //===========================================
    lateinit var disposable: Disposable

    //===========================================

    override var isRecError: Boolean = false

    lateinit var boxRec: BOX
    //===========================================
    override fun onSubscribe(d: Disposable) {
        disposable = d
    }

    override fun onNext(box: BOX) {
        this.boxRec = box
        super.onNext(box)
    }
    //===========================================

    //==================  =========================

}