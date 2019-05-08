package com.example.demo.list.fragment.rv.item

import com.example.demo.list.fragment.rv.RvVMBox
import com.example.demo.list.fragment.rv.base.BaseItemVM
import com.rebecca.lib.v.rv.BaseRvAdapter

class ItemRemoveVM : BaseItemVM() {

  lateinit var adapter: BaseRvAdapter<RvVMBox>

  override fun onClick() {
    super.onClick()
    (adapter.lastIndex - 1).let {
      if (it > 0) {
        adapter.removeAt(it)
      }
    }
  }

}