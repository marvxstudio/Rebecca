package com.rebecca.lib.v.rv.adapter

import android.content.Context
import android.databinding.ObservableArrayList
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import com.rebecca.lib.v.rv.BaseRvVM
import com.rebecca.lib.v.rv.vh.BaseKtVH
import com.rebecca.list.itf.IBaseListCtr

abstract class BaseKtAdapter<VM : BaseRvVM>(protected val list: ArrayList<VM>) : Adapter<BaseKtVH>() {

  //================================================

  //================================================

  open fun removeType(type: Int): BaseKtAdapter<VM> = this

  fun outputList(): ArrayList<VM> = list

  fun output(index: Int): VM? = null

  fun update(list: ArrayList<VM>, index: Int) {
    this.list.addAll(list)
  }
  //================================================

  open fun update(context: Context, rv: RecyclerView, manager: RecyclerView.LayoutManager = LinearLayoutManager(context), hasStableIds: Boolean = true): BaseKtAdapter<VM> {
    rv.layoutManager = manager
    rv.adapter = this
    return this
  }
}