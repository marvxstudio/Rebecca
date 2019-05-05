package com.rebecca.lib.v.rv

import android.content.Context
import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import android.support.v7.widget.RecyclerView

abstract class BaseRvAdapter<VM : BaseRvVM> : BaseKtAdapter<VM>(ObservableArrayList<VM>()) {

  //=====================  ==========================

  val mHeader by lazy { ObservableField<VM>() }
  val mFooter by lazy { ObservableField<VM>() }

  //=====================  ==========================
  val watcher: BaseListWatcher<VM> by lazy { onCreateListWatcher() }
  //=====================  ==========================

  override fun update(context: Context, rv: RecyclerView, manager: RecyclerView.LayoutManager, hasStableIds: Boolean): BaseKtAdapter<VM> {
    watcher.update(list)
    return super.update(context, rv, manager, hasStableIds)
  }

  protected open fun onCreateListWatcher(): BaseListWatcher<VM> {
    return BaseListWatcher(this)
  }

  //=====================  ==========================
  open fun updateHeader(vm: VM, isNotify: Boolean = true, position: Int = 0) {
  }

  open fun updateFooter(vm: VM, isNotify: Boolean = true, position: Int = list.size) {

  }

  //=====================  ==========================

  override fun update(list: ArrayList<VM>, isNotify: Boolean): BaseRvAdapter<VM> {
    this.list.clear()
    this.list.addAll(list)
    return this
  }

  override fun set(vm: VM, index: Int, type: Int, isNotify: Boolean): BaseRvAdapter<VM> {
    return this
  }

  override fun removeType(type: Int, isNotify: Boolean): BaseRvAdapter<VM> {
    return this
  }
  //===================== init ========================

  override fun onBindViewHolder(holder: BaseRvVH<*, VM>, position: Int) {
    holder.updateVM(list.get(position))
  }

  override fun getItemViewType(position: Int): Int {
    return list.get(position).viewType
  }

  override fun getItemCount(): Int {
    return list.size
  }

  override fun getItemId(position: Int): Long {
    var index = super.getItemId(position)
    if (hasStableIds()) {
      index = position.toLong()
    }
    return index
  }

}