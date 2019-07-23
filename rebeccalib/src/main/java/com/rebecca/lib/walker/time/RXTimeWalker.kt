package com.rebecca.lib.walker.time

import com.rebecca.lib.tools.Loger
import com.rebecca.lib.zbase.BaseCtr
import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

open class RXTimeWalker(var period: Long = 1000, var delay: Long = 0) : BaseCtr(), ITimeWalker {

  //================ ====================
  var scheduler: Scheduler = AndroidSchedulers.mainThread()
  //================ ====================
  var watcher: ITimeWalker.Watcher? = null
  protected var walker: Disposable? = null
  //================ ====================

  //================ ====================
  override fun pause() {
    walker?.let {
      if (it.isDisposed() == false) {
        it.dispose()
        walker = null
      }
    }
  }

  override fun start() {
    walker ?: let {
      walker = Flowable.interval(delay, period, TimeUnit.MILLISECONDS)
        .observeOn(scheduler)
        .subscribe { count ->
          watcher?.let {
            it.onUpdate()
            if (it.canKeepWalking() == false) {
              pause()
            }
          }
          Loger.show(mTag + "  $count", isDebug)
        }
    }
  }
  //================ ====================
}