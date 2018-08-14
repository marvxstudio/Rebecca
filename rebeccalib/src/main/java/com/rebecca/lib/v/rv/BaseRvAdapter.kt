package com.rebecca.lib.v.rv

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.LayoutManager

abstract class BaseRvAdapter<VM : BaseRvVM> : RecyclerView.Adapter<BaseRvVH<*, VM>>() {

    //=====================  ==========================
    protected lateinit var list: ArrayList<VM>

    //=====================  ==========================

    //=====================  ==========================
    companion object VHType {
        val ITEM = 0
        val DIVIDER = 1
        val HEADER = 2
        val FOOTER = 3
    }

    //=====================  ==========================
    fun update(list: ArrayList<VM>) {
        this.list = list
        notifyDataSetChanged()
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