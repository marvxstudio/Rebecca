package com.example.demo.walker.time

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.demo.R
import com.example.demo.databinding.RoutineActivityBinding
import com.example.demo.router.RouterUrl.App.Routine
import com.rebecca.lib.tools.Loger
import com.rebecca.lib.walker.event.WalkerEvent
import com.rebecca.lib.walker.time.WalkerTime
import com.rebecca.lib.zbase.activity.BaseVMActivity

@Route(path = Routine)
class RoutineActivity(override var mLayoutId: Int = R.layout.routine_activity) :
  BaseVMActivity<RoutineActivityBinding, RoutineVM>() {

  //=========================  =================================

  override val classVM: Class<RoutineVM> = RoutineVM::class.java
  //=========================  =================================
  val walkerTime = WalkerTime()
  val walkerEvent = WalkerEvent()
  //=========================  =================================

  fun walkerStart(onUpdate: () -> Unit, onFinish: () -> Unit) {
    walkerTime.start(0, 2000, {
      onUpdate()
    }, {
      onFinish()
    })
  }

  //=========================  =================================

  inner class AAP(val num: Int) : WalkerEvent.IWalkerEvent {
    override fun onStart(onEnd: () -> Unit) {
      walkerStart({ Loger.show("start= $num") }, {
        Loger.show("end $num")
        onEnd()
      })
    }
  }
  //========================= init  =================================

  override fun onInitView() {
    super.onInitView()
//
    walkerEvent.start(AAP(0), AAP(1), AAP(2))
  }
//========================= main ==================================

}