package com.example.demo.list.fragment

import android.content.Intent
import android.support.v4.app.Fragment
import com.example.demo.activity.RebeccaActivity
import com.example.demo.dialog.DialogListActivity
import com.example.demo.list.fragment.rv.FunItemVM
import com.rebecca.lib.v.rv.BaseRvAdapter
import com.rebecca.lib.zbase.vm.BaseVM

class FunListVM : BaseVM() {

    lateinit var funList: ArrayList<FunItemVM>

    fun createList(context: Fragment) {
        funList = ArrayList()
        funList.add(FunItemVM(BaseRvAdapter.HEADER))

        funList.add(FunItemVM().setName("default").setIntent(Intent(context.activity, RebeccaActivity::class.java)))
        funList.add(FunItemVM().setName("dialog list").setIntent(Intent(context.activity, DialogListActivity::class.java)))

        funList.add(FunItemVM(BaseRvAdapter.FOOTER))
    }
}