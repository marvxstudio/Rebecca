package com.example.demo.list.fragment

import android.content.Context
import com.example.demo.list.fragment.rv.FunListAdapter
import com.example.demo.list.fragment.rv.RvVMBox
import com.example.demo.list.fragment.rv.item.ItemAddVM
import com.example.demo.list.fragment.rv.item.ItemStartVM
import com.example.demo.router.RouterUrl
import com.rebecca.lib.v.rv.VHType
import com.rebecca.lib.zbase.vm.BaseVM

class FunListVM : BaseVM() {

    lateinit var funList: ArrayList<RvVMBox>

    fun createList(context: Context, adapter: FunListAdapter) {
        funList = ArrayList()
        funList.add(RvVMBox(VHType.HEADER).set(ItemStartVM()))

        funList.add(RvVMBox().set(ItemStartVM().setPath(RouterUrl.App.COMMON).setName("default")))
        funList.add(RvVMBox().set(ItemStartVM().setPath(RouterUrl.App.DIALOG).setName("dialog list")))
        funList.add(RvVMBox().set(ItemStartVM().setPath(RouterUrl.App.RX).setName("RX")))

        funList.add(RvVMBox().set(ItemAddVM().set(adapter).setName("add item")))
        funList.add(RvVMBox(VHType.FOOTER).set(ItemStartVM()))
    }
}