package com.rebecca.lib.http.rx

import com.rebecca.lib.http.bean.ICheck
import com.rebecca.lib.http.rx.base.IRec
import io.reactivex.observers.DisposableObserver

abstract class BaseVMObs<BOX : ICheck> : DisposableObserver<BOX>(), IRec<BOX> {

    //===========================================

    //===========================================

    //=================== next ========================

    override fun onNext(box: BOX) {
        if (isRec(box)) {
            onRec(box)
        }
        else {
            onError(box)
        }
    }
    //=================== complete ========================

    //================== error =========================
    override fun onError(e: Throwable) {
        if (isNetOn()) {
            onErrorNetON(e)
        }
        else {
            onErrorNetOFF(e)
        }
    }

    //===========================================
    override fun isRec(box: BOX): Boolean {
        return box.isRec()
    }
}