package com.rebecca.lib.http.rx

import com.rebecca.lib.http.bean.ICheck
import com.rebecca.lib.http.rx.base.IRec
import io.reactivex.observers.DisposableObserver

abstract class BaseVMObs<BOX : ICheck> : DisposableObserver<BOX>(), IRec<BOX> {

  //===========================================

  //===========================================
  protected var boxRec: BOX? = null
  //================== rec ======================

  override fun onNext(box: BOX) {
    boxRec = box
    if (isRec(box)) {
      onRec(box)
    }
  }

  override fun isRec(box: BOX): Boolean {
    return box.isRec()
  }

  //================ complete ====================
  override fun onComplete() {
    onFinish(boxRec)
  }

  //===========================================

  //=============== error ========================
  override fun onError(e: Throwable) {
    if (isNetOn()) {
      onErrorNetON(e)
    }
    else {
      onErrorNetOFF(e)
    }
    onFinish(boxRec)
  }

  //===========================================

}