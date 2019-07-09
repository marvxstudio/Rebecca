package com.example.demo.list.fragment.rv.base

import android.databinding.ObservableField
import com.rebecca.lib.v.rv.BaseRvVM

abstract class BaseItemVM : BaseRvVM() {

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