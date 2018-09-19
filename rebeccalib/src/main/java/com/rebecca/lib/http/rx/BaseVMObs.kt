package com.rebecca.lib.http.rx

import com.rebecca.lib.http.bean.ICheck
import io.reactivex.disposables.Disposable

abstract class BaseVMObs<BOX : ICheck> : IVMObserver<BOX> {

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
    override fun isRec(box: BOX): Boolean {
        return box.isRec()
    }
    //==================  =========================

}