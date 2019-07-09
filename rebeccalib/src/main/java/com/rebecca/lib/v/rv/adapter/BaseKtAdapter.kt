package com.rebecca.lib.v.rv.adapter

import android.content.Context
import android.databinding.ObservableArrayList
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import com.rebecca.lib.v.rv.BaseRvVM
import com.rebecca.lib.v.rv.vh.BaseKtVH
import com.rebecca.list.itf.IBaseListCtr

abstract class BaseKtAdapter<VM : BaseRvVM>(protected val list: ObservableArrayList<VM>) : Adapter<BaseKtVH>(), IBaseListCtr<VM>, MutableList<VM> by list {

  //================================================

  //================================================

  open fun removeType(type: Int): BaseKtAdapter<VM> = this

  override fun outputList(): ArrayList<VM> = list

  override fun output(index: Int): VM? = if (index in list.indices) get(index) else super.output(index)

  override fun update(list: ArrayList<VM>, index: Int) {
    clear()
    addAll(list)
  }
  //================================================

  /*
   LinearLayoutManager 线性布局管理器
   GridLayoutManager 表格布局管理器
   StaggeredGridLayoutManager 瀑布流布局管理器
   */
  open fun update(context: Context, rv: RecyclerView, manager: RecyclerView.LayoutManager = LinearLayoutManager(context), hasStableIds: Boolean = true): BaseKtAdapter<VM> {
    rv.layoutManager = manager
    setHasStableIds(hasStableIds)
    rv.adapter = this
    return this
  }
}