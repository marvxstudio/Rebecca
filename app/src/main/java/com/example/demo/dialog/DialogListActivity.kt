package com.example.demo.dialog

import com.example.demo.R
import com.example.demo.databinding.FlLayoutBinding
import com.rebecca.lib.zbase.activity.BaseVMActivity

class DialogListActivity(override var mLayoutId: Int = R.layout.fl_layout) : BaseVMActivity<FlLayoutBinding,
        DialogListVM>() {
    //=========================  =================================

    //=========================  =================================

    //========================= init  =================================

    override fun onInitView() {
        super.onInitView()
        supportFragmentManager.beginTransaction().add(ui.flFragment.id, DialogListFragment()).commit()
    }
    //========================= main ==================================
}