package com.rebecca.lib.v.rv.vh

import android.arch.lifecycle.ViewModel
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.rebecca.lib.tools.ToolsView
import com.rebecca.lib.v.rv.BaseRvVM

abstract class BaseKtVH(vg: ViewGroup, id: Int) : RecyclerView.ViewHolder(ToolsView.inflate(id, vg)) {

  abstract fun updateData(index: Int)
}