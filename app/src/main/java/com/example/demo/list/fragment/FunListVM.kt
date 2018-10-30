package com.example.demo.list.fragment

import android.content.Context
import android.content.Intent
import com.example.demo.activity.RebeccaActivity
import com.example.demo.dialog.DialogListActivity
import com.example.demo.list.fragment.rv.FunListAdapter
import com.example.demo.list.fragment.rv.RvVMBox
import com.example.demo.list.fragment.rv.item.ItemAddVM
import com.example.demo.list.fragment.rv.item.ItemStartVM
import com.rebecca.lib.v.rv.VHType
import com.rebecca.lib.zbase.vm.BaseVM

class FunListVM : BaseVM() {

    lateinit var funList: ArrayList<RvVMBox>

    fun createList(context: Context, adapter: FunListAdapter) {
        funList = ArrayList()
        funList.add(RvVMBox(VHType.HEADER).set(ItemStartVM()))

        funList.add(RvVMBox().set(ItemStartVM().setIntent(Intent(context, RebeccaActivity::class.java)).setName("default")))
        funList.add(RvVMBox().set(ItemStartVM().setIntent(Intent(context, DialogListActivity::class.java)).setName("dialog list")))


        funList.add(RvVMBox().set(ItemAddVM().set(adapter).setName("add item")))
        funList.add(RvVMBox(VHType.FOOTER).set(ItemStartVM()))
    }
}