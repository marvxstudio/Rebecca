package com.rebecca.lib.v.rv

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.LayoutManager

abstract class BaseRvAdapter<VM : BaseRvVM> : Adapter<BaseRvVH<*, VM>>() {

    //=====================  ==========================
    protected lateinit var list: ArrayList<VM>

    //=====================  ==========================

    //=====================  ==========================
    companion object VHType {
        const val ITEM = 0
        const val DIVIDER = 1
        const val HEADER = 2
        const val FOOTER = 3
    }

    //=====================  ==========================
    fun update(list: ArrayList<VM>, isNotify: Boolean = true): BaseRvAdapter<VM> {
        this.list = list
        if (isNotify) {
            notifyDataSetChanged()
        }
        return this
    }

    fun clear(isNotify: Boolean = true): BaseRvAdapter<VM> {
        list.clear()
        if (isNotify) {
            notifyDataSetChanged()
        }
        return this
    }

    fun add(list: ArrayList<VM>, isNotify: Boolean = true): BaseRvAdapter<VM> {
        this.list.addAll(list)
        if (isNotify) {
            notifyDataSetChanged()
        }
        return this
    }

    fun add(vm: VM, index: Int = indexLast(), isNotify: Boolean = true): BaseRvAdapter<VM> {
        list.add(index, vm)
        if (isNotify) {
            notifyDataSetChanged()
        }
        return this
    }

    fun indexLast(offset: Int = 0): Int {
        return list.size - offset
    }

    //===================== init ========================
    /*
     LinearLayoutManager 线性布局管理器
     GridLayoutManager 表格布局管理器
     StaggeredGridLayoutManager 瀑布流布局管理器
     */
    open fun updateLayoutManager(context: Context, rv: RecyclerView, manager: LayoutManager = LinearLayoutManager(context)) {
        rv.layoutManager = manager
    }
    //===================== main ========================

    override fun onBindViewHolder(holder: BaseRvVH<*, VM>, position: Int) {
        holder.updateVM(list.get(position))
    }

    override fun getItemViewType(position: Int): Int {
        return list.get(position).viewType
    }

    override fun getItemCount(): Int {
        return list.size
    }
}