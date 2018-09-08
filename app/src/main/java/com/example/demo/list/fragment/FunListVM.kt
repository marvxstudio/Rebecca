package com.example.demo.list.fragment

import android.content.Context
import android.content.Intent
import com.example.demo.activity.RebeccaActivity
import com.example.demo.dialog.DialogListActivity
import com.example.demo.list.fragment.rv.FunItemVM
import com.example.demo.rx.Obs
import com.rebecca.lib.v.rv.BaseRvAdapter
import com.rebecca.lib.zbase.vm.BaseVM

class FunListVM : BaseVM() {

    lateinit var funList: ArrayList<FunItemVM>

    fun createList(context: Context) {
        funList = ArrayList()
        funList.add(FunItemVM(BaseRvAdapter.HEADER))

        funList.add(FunItemVM().setName("default").setIntent(Intent(context, RebeccaActivity::class.java)))
        funList.add(FunItemVM().setName("dialog list").setIntent(Intent(context, DialogListActivity::class.java)))

        funList.add(FunItemVM(BaseRvAdapter.FOOTER))
    }

    fun k() {
        val obs = object : Obs<FunListVM> {
            override fun onRec(b: ArrayList<FunListVM>) {
            }

            override fun onComplete() {
            }
        }
    }
}