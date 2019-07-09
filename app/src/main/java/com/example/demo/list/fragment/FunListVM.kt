package com.example.demo.list.fragment

import android.databinding.ObservableArrayList
import com.example.demo.list.fragment.rv.base.BaseItemVM
import com.example.demo.list.fragment.rv.item.ItemAddVM
import com.example.demo.list.fragment.rv.item.ItemRemoveVM
import com.example.demo.list.fragment.rv.item.ItemStartVM
import com.example.demo.router.RouterUrl
import com.rebecca.lib.v.rv.BaseRvVM
import com.rebecca.lib.v.rv.VHType
import com.rebecca.lib.zbase.vm.BaseVM

class FunListVM : BaseVM() {

  //======================== ===================
  val funList: ObservableArrayList<BaseRvVM> = ObservableArrayList()
  //======================== ===================

  fun createList() {
    funList.let {
      it.clear()
      it.add(ItemStartVM(VHType.HEADER))

      it.add(ItemStartVM().setPath(RouterUrl.App.COMMON).setName("default"))
      it.add(ItemStartVM().setPath(RouterUrl.App.DIALOG).setName("dialog list"))
      it.add(ItemStartVM().setPath(RouterUrl.App.RX).setName("RX"))
      it.add(ItemStartVM().setPath(RouterUrl.App.Font).setName("Font"))
      it.add(ItemStartVM().setPath(RouterUrl.App.Web).setName("Web"))
      ItemRemoveVM().apply {
        watcher = object : BaseItemVM.Watcher {
          override fun onClick() {
            if (it.isNotEmpty()) {
              it.removeAt(it.lastIndex - 1)
            }
          }
        }
        setName("remove item")
        it.add(this)
      }

      ItemAddVM().setName("add item").apply {
        watcher = object : BaseItemVM.Watcher {
          override fun onClick() {
            val index = if (it.isNotEmpty()) it.lastIndex else 0
            it.add(index, this@apply)
          }
        }

        it.add(this@apply)
      }
      it.add(ItemStartVM(VHType.FOOTER))
    }
  }

  //======================== ===================

}