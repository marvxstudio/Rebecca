package com.rebecca.lib.v.rv.vh

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.rebecca.lib.tools.ToolsView

abstract class BaseKtVH(vg: ViewGroup, id: Int) : RecyclerView.ViewHolder(ToolsView.inflate(id, vg)) {

  abstract fun updateData(any: Any)
}