package com.example.demo.list.fragment.rv

import android.view.ViewGroup
import com.example.demo.list.fragment.rv.footer.FunFooterVH
import com.example.demo.list.fragment.rv.header.FunHeaderVH
import com.example.demo.list.fragment.rv.item.FunItemVH
import com.rebecca.lib.v.rv.VHType
import com.rebecca.lib.v.rv.adapter.BaseRvAdapter
import com.rebecca.lib.v.rv.vh.BaseRvVH

class FunListAdapter : BaseRvAdapter<RvVMBox>() {
  //=========================  =================================

  //=========================  =================================

  //========================= main ==================================

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRvVH<*, RvVMBox> {
    val vh: BaseRvVH<*, RvVMBox> = when (viewType) {

      VHType.HEADER -> FunHeaderVH(parent)

      VHType.FOOTER -> FunFooterVH(parent)

      else -> FunItemVH(parent).set(this)
    }
    return vh
  }
}