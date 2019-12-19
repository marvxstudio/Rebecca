package com.example.demo.list.fragment.rv

import android.databinding.ObservableArrayList
import android.view.ViewGroup
import com.example.demo.list.fragment.rv.base.BaseItemVM
import com.example.demo.list.fragment.rv.footer.FooterVH
import com.example.demo.list.fragment.rv.header.HeaderVH
import com.example.demo.list.fragment.rv.item.FunItemVH
import com.rebecca.lib.v.rv.adapter.BaseRvAdapter
import com.rebecca.lib.v.rv.vh.BaseKtVH

class FunListAdapter(list: ObservableArrayList<BaseItemVM>) : BaseRvAdapter<BaseItemVM>(list) {
  //=========================  =================================

  //=========================  =================================
  object VHType {
    const val HEADER = 0
    const val ITEM = 1
    const val FOOTER = 3
  }
  //========================= main ==================================

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseKtVH {
    return when (viewType) {

      VHType.HEADER -> HeaderVH(parent)

      VHType.FOOTER -> FooterVH(parent)

      else -> FunItemVH(parent)
    }
  }
}