package com.rebecca.lib.walker.event

import com.rebecca.lib.zbase.BaseCtr
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscription

open class WalkerEvent : BaseCtr() {

  fun <T : IWalkerEvent> start(vararg workList: T) {
    var suber: Subscription? = null
    val d = Flowable.create(FlowableOnSubscribe<T> { e ->
      workList.forEach {
        e.onNext(it)
      }
    }, BackpressureStrategy.BUFFER)
      .subscribeOn(Schedulers.newThread())
      .subscribeOn(AndroidSchedulers.mainThread())
      .subscribe({
        it?.let {
          it.onStart {
            suber?.request(1)
          }
        }
      }, {

      }, {

      }, {
        suber = it
        it.request(1)
      })

//    object : FlowableSubscriber<T> {
//      var suber: Subscription? = null
//      override fun onSubscribe(s: Subscription) {
//        suber = s
//        s.request(1)
//      }
//
//      override fun onNext(t: T?) {
//        t?.let {
//          it.onStart {
//            suber?.request(1)
//          }
//        }
//      }
//
//      override fun onError(t: Throwable?) {
//      }
//
//      override fun onComplete() {
//        Loger.show("runner onComplete")
//      }
//    }
  }

  //================== ====================
  interface IWalkerEvent {
    fun onStart(onEnd: () -> Unit)
  }

}