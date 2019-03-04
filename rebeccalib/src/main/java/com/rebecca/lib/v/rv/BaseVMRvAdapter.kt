package com.rebecca.lib.v.rv

import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import android.databinding.ObservableList

abstract class BaseVMRvAdapter<VM : BaseRvVM> : BaseKtAdapter<VM>() {

  //=====================  ==========================
  val mlist by lazy { onCreateObservableArrayList() }
  //=====================  ==========================
  //=====================  ==========================

  var mListItem = ObservableField<VM>()
  val mHeader by lazy { ObservableField<VM>() }
  val mFooter by lazy { ObservableField<VM>() }
  //=====================  ==========================

  open fun onCreateObservableArrayList(): ObservableArrayList<VM> {
    val list = ObservableArrayList<VM>().also {
      it.addOnListChangedCallback(object : ObservableList.OnListChangedCallback<ObservableArrayList<VM>>() {
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
    return list
  }

  //=====================  ==========================

  //=====================  ==========================
  open fun updateHeader(vm: VM, isNotify: Boolean = true, position: Int = 0) {
  }

  open fun updateFooter(vm: VM, isNotify: Boolean = true, position: Int = mlist.size) {

  }

  override fun getListSize(offset: Int): Int {
    return mlist.size + offset
  }

  fun getList(): ObservableArrayList<VM> {
    return mlist
  }
  //=====================  ==========================

  override fun update(list: ArrayList<VM>, isNotify: Boolean): BaseVMRvAdapter<VM> {
    mlist.clear()
    mlist.addAll(list)

    return this
  }

  override fun clear(isNotify: Boolean): BaseVMRvAdapter<VM> {
    mlist.clear()

    return this
  }

  override fun add(list: ArrayList<VM>, isNotify: Boolean): BaseVMRvAdapter<VM> {
    mlist.addAll(list)

    return this
  }

  override fun add(vm: VM, index: Int, isNotify: Boolean): BaseVMRvAdapter<VM> {
    mlist.add(index, vm)

    return this
  }

  override fun remove(index: Int, isNotify: Boolean): BaseVMRvAdapter<VM> {
    return this
  }

  override fun set(vm: VM, index: Int, isNotify: Boolean): BaseVMRvAdapter<VM> {
    return this
  }

  override fun set(vm: VM, index: Int, type: Int, isNotify: Boolean): BaseVMRvAdapter<VM> {
    return this
  }

  override fun removeType(type: Int, isNotify: Boolean): BaseVMRvAdapter<VM> {
    return this
  }
  //===================== init ========================

  override fun onBindViewHolder(holder: BaseRvVH<*, VM>, position: Int) {
    holder.updateVM(mlist.get(position))
  }

  override fun getItemViewType(position: Int): Int {
    return mlist.get(position).viewType
  }

  override fun getItemCount(): Int {
    return mlist.size
  }

  override fun getItemId(position: Int): Long {
    var index = super.getItemId(position)
    if (hasStableIds()) {
      index = position.toLong()
    }
    return index
  }
}