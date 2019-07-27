package com.example.demo.walker.time

import com.rebecca.lib.tools.Loger
import com.rebecca.lib.walker.event.WalkerEvent
import com.rebecca.lib.walker.time.WalkerTime
import com.rebecca.lib.zbase.vm.BaseVM

class RoutineVM : BaseVM() {

  val walkerEvent = WalkerEvent()
  val walkerTime = WalkerTime()

  //=========================  =================================
  inner class AAP(val num: Int) : WalkerEvent.IWalkerEvent {
    override fun onStart(onEnd: () -> Unit) {
      walkerStart({ Loger.show("start= $num") }, {
        Loger.show("end $num")
        onEnd()
      })
    }
  }

  fun walkerStart(onUpdate: () -> Unit, onFinish: () -> Unit) {
    walkerTime.start(0, 2000, {
      onUpdate()
    }, {
      onFinish()
    })
  }

  fun ond() {
    walkerEvent.start(AAP(0), AAP(1), AAP(2))
  }
}