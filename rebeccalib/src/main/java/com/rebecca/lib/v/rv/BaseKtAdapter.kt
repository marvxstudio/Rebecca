package com.rebecca.lib.v.rv

import android.content.Context
import android.databinding.ObservableArrayList
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter

abstract class BaseKtAdapter<VM : BaseRvVM>(protected val list: ObservableArrayList<VM>) : Adapter<BaseRvVH<*, VM>>(), MutableList<VM> by list {

  //================================================
  open var openAutoNotify = true

  //================================================
  abstract fun update(list: ArrayList<VM>, isNotify: Boolean = openAutoNotify): BaseKtAdapter<VM>

  abstract fun set(vm: VM, index: Int, type: Int, isNotify: Boolean = openAutoNotify): BaseKtAdapter<VM>

  abstract fun removeType(type: Int, isNotify: Boolean = openAutoNotify): BaseKtAdapter<VM>

  open fun output(): ObservableArrayList<VM> {
    return list
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