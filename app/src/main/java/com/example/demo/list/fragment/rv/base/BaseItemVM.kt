package com.example.demo.list.fragment.rv.base

import android.databinding.ObservableField
import com.example.demo.list.fragment.rv.FunListAdapter.VHType
import com.rebecca.lib.v.rv.BaseRvVM

abstract class BaseItemVM(override var viewType: Int = VHType.ITEM) : BaseRvVM() {

  val name = ObservableField<String>()

  var watcher: Watcher? = null

  open fun onClick() {
    watcher?.onClick()
  }

  fun setName(name: String): BaseItemVM {
    this.name.set(name)
    return this
  }

  interface Watcher {
    fun onClick()
  }
}