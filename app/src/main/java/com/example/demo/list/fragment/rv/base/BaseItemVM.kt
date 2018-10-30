package com.example.demo.list.fragment.rv.base

import android.databinding.ObservableField
import com.rebecca.lib.v.rv.BaseRvVM

abstract class BaseItemVM : BaseRvVM() {

    val name = ObservableField<String>()

    open fun onClick() {
    }

    fun setName(name: String): BaseItemVM {
        this.name.set(name)
        return this
    }
}