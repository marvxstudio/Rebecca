package com.example.demo.dialog

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.demo.R
import com.example.demo.databinding.FlLayoutBinding
import com.example.demo.dialog.fragment.MaterialDialogFragment
import com.example.demo.router.RouterUrl
import com.rebecca.lib.zbase.activity.BaseVMActivity

@Route(path = RouterUrl.App.DIALOG)
class DialogListActivity(override var mLayoutId: Int = R.layout.fl_layout) : BaseVMActivity<FlLayoutBinding,
  DialogListVM>() {
  //=========================  =================================

  //=========================  =================================

  //========================= init  =================================

  override fun onInitView() {
    super.onInitView()
    DialogListFragment().addTo(ui.flFragment.id, supportFragmentManager)
  }

  override fun onDestroy() {
    super.onDestroy()
    dialogManager.add(MaterialDialogFragment())
  }
}