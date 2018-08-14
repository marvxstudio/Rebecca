package com.example.demo.list.fragment

import android.content.Context
import android.content.Intent
import com.example.demo.activity.RebeccaActivity
import com.example.demo.list.fragment.rv.FunItemVM
import com.rebecca.lib.v.rv.BaseRvAdapter
import com.rebecca.lib.zbase.vm.BaseVM

class FunListVM : BaseVM() {

    lateinit var funList: ArrayList<FunItemVM>

    fun createList(context: Context) {
        funList = ArrayList()
        funList.add(FunItemVM(BaseRvAdapter.HEADER))
        funList.add(FunItemVM().setName("default").setIntent(Intent(context, RebeccaActivity::class.java)))
        funList.add(FunItemVM(BaseRvAdapter.FOOTER))
    }
}