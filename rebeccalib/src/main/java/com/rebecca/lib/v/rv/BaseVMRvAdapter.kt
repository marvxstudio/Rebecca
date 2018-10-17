package com.rebecca.lib.v.rv

import android.content.Context
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

abstract class BaseVMRvAdapter<VM : BaseRvVM> : RecyclerView.Adapter<BaseRvVH<*, VM>>() {

    //=====================  ==========================
    lateinit var mlist: ObservableArrayList<VM>

    //=====================  ==========================
    open protected fun onInitList(list: ObservableArrayList<VM> = ObservableArrayList()) {
        mlist = list
        mlist.addOnListChangedCallback(object : ObservableList.OnListChangedCallback<ObservableArrayList<VM>>() {
            override fun onChanged(sender: ObservableArrayList<VM>?) {
                notifyDataSetChanged()
            }

            override fun onItemRangeRemoved(sender: ObservableArrayList<VM>?, positionStart: Int, itemCount: Int) {
                notifyItemRangeRemoved(positionStart, itemCount)
            }

            override fun onItemRangeMoved(sender: ObservableArrayList<VM>?, fromPosition: Int, toPosition: Int, itemCount: Int) {
                notifyDataSetChanged()
            }

            override fun onItemRangeInserted(sender: ObservableArrayList<VM>?, positionStart: Int, itemCount: Int) {
                notifyItemRangeInserted(positionStart, itemCount)
            }

            override fun onItemRangeChanged(sender: ObservableArrayList<VM>?, positionStart: Int, itemCount: Int) {
                notifyItemRangeChanged(positionStart, itemCount)
            }
        })
    }

    //=====================  ==========================


    //=====================  ==========================
    fun update(list: ObservableArrayList<VM>, isNotify: Boolean = true): BaseVMRvAdapter<VM> {
        mlist.clear()
        mlist.addAll(list)
        if (isNotify) {
            notifyDataSetChanged()
        }
        return this
    }

    fun clear(isNotify: Boolean = true): BaseVMRvAdapter<VM> {
        mlist.clear()
        if (isNotify) {
            notifyDataSetChanged()
        }
        return this
    }

    fun add(list: ArrayList<VM>, isNotify: Boolean = true): BaseVMRvAdapter<VM> {
        mlist.addAll(list)
        if (isNotify) {
            notifyDataSetChanged()
        }
        return this
    }

    fun add(vm: VM, index: Int = getSizeOffset(), isNotify: Boolean = true): BaseVMRvAdapter<VM> {
        mlist.add(index, vm)
        if (isNotify) {
            notifyDataSetChanged()
        }
        return this
    }

    fun getSizeOffset(offset: Int = 0): Int {
        return mlist.size + offset
    }

    fun getList(): ObservableArrayList<VM> {
        return mlist
    }

    //===================== init ========================
    /*
     LinearLayoutManager 线性布局管理器
     GridLayoutManager 表格布局管理器
     StaggeredGridLayoutManager 瀑布流布局管理器
     */
    open fun updateLayoutManager(context: Context, rv: RecyclerView, manager: RecyclerView.LayoutManager = LinearLayoutManager(context)) {
        rv.layoutManager = manager
    }

    init {
        onInitList()
    }
    //===================== main ========================

    override fun onBindViewHolder(holder: BaseRvVH<*, VM>, position: Int) {
        holder.updateVM(mlist.get(position))
    }

    override fun getItemViewType(position: Int): Int {
        return mlist.get(position).viewType
    }

    override fun getItemCount(): Int {
        return mlist.size
    }
}