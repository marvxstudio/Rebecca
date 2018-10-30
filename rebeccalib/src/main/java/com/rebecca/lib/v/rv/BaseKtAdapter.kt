package com.rebecca.lib.v.rv

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter

abstract class BaseKtAdapter<VM : BaseRvVM> : Adapter<BaseRvVH<*, VM>>() {

    //================================================
    open var openAutoNotify = true

    //================================================
    abstract fun update(list: ArrayList<VM>, isNotify: Boolean = openAutoNotify): BaseKtAdapter<VM>

    abstract fun clear(isNotify: Boolean = openAutoNotify): BaseKtAdapter<VM>

    abstract fun add(list: ArrayList<VM>, isNotify: Boolean = openAutoNotify): BaseKtAdapter<VM>

    abstract fun add(vm: VM, index: Int = getListSize(), isNotify: Boolean = openAutoNotify): BaseKtAdapter<VM>

    abstract fun getListSize(offset: Int = 0): Int
    //================================================

    /*
     LinearLayoutManager 线性布局管理器
     GridLayoutManager 表格布局管理器
     StaggeredGridLayoutManager 瀑布流布局管理器
     */
    open fun updateLayoutManager(context: Context, rv: RecyclerView, manager: RecyclerView.LayoutManager = LinearLayoutManager(context)) {
        rv.layoutManager = manager
    }
}