package com.example.demo.list.fragment

import android.databinding.ObservableArrayList
import com.example.demo.list.fragment.rv.RvVMBox
import com.example.demo.list.fragment.rv.item.ItemAddVM
import com.example.demo.list.fragment.rv.item.ItemRemoveVM
import com.example.demo.list.fragment.rv.item.ItemStartVM
import com.example.demo.router.RouterUrl
import com.rebecca.lib.v.rv.VHType
import com.rebecca.lib.v.rv.adapter.BaseRvAdapter
import com.rebecca.lib.zbase.vm.BaseVM

class FunListVM : BaseVM() {

  //======================== ===================
  lateinit var watcher: Watcher
  val funList: ObservableArrayList<RvVMBox> = ObservableArrayList()
  //======================== ===================

  fun createList(adapter: BaseRvAdapter<RvVMBox>) {
    funList.clear()
    funList.add(RvVMBox(VHType.HEADER).set(ItemStartVM()))

    funList.add(RvVMBox().set(ItemStartVM().setPath(RouterUrl.App.COMMON).setName("default")))
    funList.add(RvVMBox().set(ItemStartVM().setPath(RouterUrl.App.DIALOG).setName("dialog list")))
    funList.add(RvVMBox().set(ItemStartVM().setPath(RouterUrl.App.RX).setName("RX")))
    funList.add(RvVMBox().set(ItemStartVM().setPath(RouterUrl.App.Font).setName("Font")))
    funList.add(RvVMBox().set(ItemStartVM().setPath(RouterUrl.App.Web).setName("Web")))
    funList.add(RvVMBox().set(ItemRemoveVM().also {
      it.adapter = adapter
      it.setName("remove item")
    }))

    funList.add(RvVMBox().set(ItemAddVM().set(adapter).setName("add item")))
    funList.add(RvVMBox(VHType.FOOTER).set(ItemStartVM()))

//    watcher.onUpdate(funList)
  }

  //======================== ===================
  interface Watcher {
    fun onUpdate(list: ArrayList<RvVMBox>)
  }
}