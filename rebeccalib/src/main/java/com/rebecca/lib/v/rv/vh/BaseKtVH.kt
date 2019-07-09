package com.rebecca.lib.v.rv.vh

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.rebecca.lib.tools.ViewTools

abstract class BaseKtVH(vg: ViewGroup, id: Int) : RecyclerView.ViewHolder(ViewTools.inflate(id, vg)) {

  abstract fun updateData(any: Any)
}