package com.example.demo.list.fragment.rv.item

import com.example.demo.list.fragment.rv.RvVMBox
import com.example.demo.list.fragment.rv.base.BaseItemVM
import com.rebecca.lib.v.rv.adapter.BaseRvAdapter

class ItemAddVM : BaseItemVM() {

  lateinit var adapter: BaseRvAdapter<RvVMBox>

  //======================
  override fun onClick() {
    super.onClick()
    val item = RvVMBox().set(ItemAddVM().set(adapter).setName(name.get() ?: ""))
    adapter.let {
      it.add(it.lastIndex, item)
    }
  }

  fun set(adapter: BaseRvAdapter<RvVMBox>): ItemAddVM {
    this.adapter = adapter
    return this
  }
}