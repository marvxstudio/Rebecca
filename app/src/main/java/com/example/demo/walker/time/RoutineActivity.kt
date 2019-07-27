package com.example.demo.walker.time

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.demo.R
import com.example.demo.databinding.RoutineActivityBinding
import com.example.demo.router.RouterUrl.App.Routine
import com.rebecca.lib.zbase.activity.BaseVMActivity

@Route(path = Routine)
class RoutineActivity(override var mLayoutId: Int = R.layout.routine_activity) :
  BaseVMActivity<RoutineActivityBinding, RoutineVM>() {

  //=========================  =================================

  override val classVM: Class<RoutineVM> = RoutineVM::class.java
  //=========================  =================================

  //=========================  =================================

  //========================= init  =================================

  override fun onInitView() {
    super.onInitView()
    vm.ond()

  }
//========================= main ==================================

}