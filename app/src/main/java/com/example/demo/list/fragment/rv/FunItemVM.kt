package com.example.demo.list.fragment.rv

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.content.Intent
import com.rebecca.lib.v.rv.BaseRvAdapter
import com.rebecca.lib.v.rv.BaseRvVM

class FunItemVM(override var viewType: Int = BaseRvAdapter.ITEM) : BaseRvVM() {

    var name = MutableLiveData<String>()
    lateinit var intent: Intent

    fun setName(name: String): FunItemVM {
        this.name.postValue(name)
        return this
    }

    fun setIntent(i: Intent): FunItemVM {
        intent = i
        return this
    }

    fun start(context: Context) {
        context.startActivity(intent)
    }
}