package com.example.demo.list.fragment.rv.item

import com.example.demo.list.fragment.rv.RvVMBox
import com.example.demo.list.fragment.rv.base.BaseItemVM
import com.rebecca.lib.v.rv.BaseRvAdapter

class ItemAddVM : BaseItemVM() {

  lateinit var adapter: BaseRvAdapter<RvVMBox>

  //======================
  override fun onClick() {
    super.onClick()
    adapter.add(RvVMBox().set(ItemAddVM()
      .set(adapter).setName(name.get() ?: "")), adapter.getListSize(-1))
  }

  fun set(adapter: BaseRvAdapter<RvVMBox>): ItemAddVM {
    this.adapter = adapter
    return this
  }
}