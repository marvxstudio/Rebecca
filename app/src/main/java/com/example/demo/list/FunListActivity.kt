package com.example.demo.list

import com.example.demo.R
import com.example.demo.databinding.FunListActivityBinding
import com.example.demo.list.fragment.FunListFragment
import com.rebecca.lib.zbase.activity.BaseVMActivity

class FunListActivity(override var mLayoutId: Int = R.layout.fun_list_activity) : BaseVMActivity<FunListActivityBinding,
  FunListActivityVM>() {

  //=========================  =================================

  //=========================  =================================
  fun initFragment() {
    var ft = supportFragmentManager.beginTransaction()
    ft.add(ui.flFragment.id, FunListFragment())
    ft.commit()
  }
  //========================= init  =================================

  override fun onCreateVM(vm: FunListActivityVM): FunListActivityVM {
    return super.onCreateVM(vm)
  }

  override fun onInitView() {
    super.onInitView()
    ui.vm = createVM(FunListActivityVM::class.java)
    initFragment()

  }
  //========================= main ==================================
}