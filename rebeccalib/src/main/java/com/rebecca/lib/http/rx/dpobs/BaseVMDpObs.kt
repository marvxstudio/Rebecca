package com.rebecca.lib.http.rx.dpobs

import com.rebecca.lib.http.bean.ICheck
import com.rebecca.lib.http.rx.base.IRec
import io.reactivex.observers.DisposableObserver

abstract class BaseVMDpObs<BOX : ICheck> : DisposableObserver<BOX>(), IRec<BOX> {

  //===========================================
  var isRecError: Boolean = false

  //===========================================
  lateinit var boxRec: BOX
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
    if (isRecComplete()) {
      onRecComplete()
    }
  }

  fun isRecComplete(isComplete: Boolean = (isRecError == false)): Boolean {
    return isComplete
  }

  abstract fun onRecComplete()

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

  //===========================================

}