package com.example.demo.permit.rv

import android.databinding.ObservableArrayList
import android.view.ViewGroup
import com.rebecca.lib.v.rv.adapter.BaseRvAdapter
import com.rebecca.lib.v.rv.vh.BaseKtVH

class PermitAdapter(list: ObservableArrayList<PermitItemVM>) : BaseRvAdapter<PermitItemVM>(list) {

  override fun onCreateViewHolder(vg: ViewGroup, type: Int): BaseKtVH {
    return PermitItemVH(vg)
  }
}