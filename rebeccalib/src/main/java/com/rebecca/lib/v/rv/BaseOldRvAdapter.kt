package com.rebecca.lib.v.rv

import android.databinding.ObservableArrayList

abstract class BaseOldRvAdapter<VM : BaseRvVM> : BaseKtAdapter<VM>(ObservableArrayList<VM>()) {

  //=====================  ==========================

  //=====================  ==========================

  //=====================  ==========================

  //=====================  ==========================

//  override fun update(list: ArrayList<VM>, isNotify: Boolean): BaseOldRvAdapter<VM> {
//    this.mlist = list
//    if (isNotify) {
//      notifyDataSetChanged()
//    }
//    return this
//  }
//
//  override fun clear(isNotify: Boolean): BaseOldRvAdapter<VM> {
//    mlist.clear()
//    if (isNotify) {
//      notifyDataSetChanged()
//    }
//    return this
//  }
//
//  override fun add(list: ArrayList<VM>, isNotify: Boolean): BaseOldRvAdapter<VM> {
//    this.mlist.addAll(list)
//    if (isNotify) {
//      notifyDataSetChanged()
//    }
//    return this
//  }
//
//  override fun add(vm: VM, index: Int, isNotify: Boolean): BaseOldRvAdapter<VM> {
//    mlist.add(index, vm)
//    if (isNotify) {
//      notifyDataSetChanged()
//    }
//    return this
//  }
//
//  override fun remove(index: Int, isNotify: Boolean): BaseOldRvAdapter<VM> {
//    return this
//  }
//
//  override fun set(vm: VM, index: Int, isNotify: Boolean): BaseOldRvAdapter<VM> {
//    return this
//  }
//
//  override fun set(vm: VM, index: Int, type: Int, isNotify: Boolean): BaseOldRvAdapter<VM> {
//    return this
//  }
//
//  override fun removeType(type: Int, isNotify: Boolean): BaseOldRvAdapter<VM> {
//    return this
//  }
//
//  override fun getListSize(offset: Int): Int {
//    return mlist.size + offset
//  }
//
//  //===================== init ========================
//  fun getList(): ArrayList<VM> {
//    return mlist
//  }
//  //===================== main ========================
//
//  override fun onBindViewHolder(holder: BaseRvVH<*, VM>, position: Int) {
//    holder.updateVM(mlist.get(position))
//  }
//
//  override fun getItemViewType(position: Int): Int {
//    return mlist.get(position).viewType
//  }
//
//  override fun getItemCount(): Int {
//    return mlist.size
//  }
}