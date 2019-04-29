package com.example.demo.list.fragment.rv.item

import com.example.demo.list.fragment.rv.RvVMBox
import com.example.demo.list.fragment.rv.base.BaseItemVM
import com.rebecca.lib.v.rv.BaseRvAdapter

class ItemRemoveVM : BaseItemVM() {

  lateinit var adapter: BaseRvAdapter<RvVMBox>

  override fun onClick() {
    super.onClick()

    adapter.removeAt(adapter.lastIndex - 1)
  }

}