package com.example.demo.list.fragment

import android.databinding.ObservableArrayList
import com.example.demo.list.fragment.rv.base.BaseItemVM
import com.example.demo.list.fragment.rv.footer.FooterVM
import com.example.demo.list.fragment.rv.header.HeaderVM
import com.example.demo.list.fragment.rv.item.ItemAddVM
import com.example.demo.list.fragment.rv.item.ItemRemoveVM
import com.example.demo.list.fragment.rv.item.ItemStartVM
import com.example.demo.router.RouterUrl
import com.rebecca.lib.zbase.vm.BaseKtVM

class FunListVM : BaseKtVM() {

  //======================== ===================
  val funList: ObservableArrayList<BaseItemVM> = ObservableArrayList()
  //======================== ===================

  fun createList() {
    funList.let {
      it.clear()
      it.add(HeaderVM())

      it.add(ItemStartVM().setPath(RouterUrl.App.COMMON).setName("default"))
      it.add(ItemStartVM().setPath(RouterUrl.App.DIALOG).setName("dialog list"))
      it.add(ItemStartVM().setPath(RouterUrl.App.RX).setName("RX"))
      it.add(ItemStartVM().setPath(RouterUrl.App.Font).setName("Font"))
      it.add(ItemStartVM().setPath(RouterUrl.App.Web).setName("Web"))
      it.add(ItemStartVM().setPath(RouterUrl.App.Routine).setName("Routine"))
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
      it.add(FooterVM())
    }
  }

  //======================== ===================

}