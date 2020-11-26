package com.rebecca.lib.v.rv.adapter

import android.content.Context
import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import com.rebecca.lib.v.rv.BaseListWatcher
import com.rebecca.lib.v.rv.BaseRvVM
import com.rebecca.lib.v.rv.vh.BaseKtVH

abstract class BaseRvAdapter<VM : BaseRvVM>(val list: ArrayList<VM>, private val count: Int = list.size) : Adapter<BaseKtVH<VM>>() {

  //=====================  ==========================

  //=====================  ==========================

  val mHeader by lazy { ObservableField<VM>() }
  val mFooter by lazy { ObservableField<VM>() }

  //=====================  ==========================
  //=====================  ==========================

  protected open fun onCreateListWatcher(): BaseListWatcher<VM> {
    return BaseListWatcher(this)
  }

  //=====================  ==========================
  open fun updateHeader(vm: VM, isNotify: Boolean = true, position: Int = 0) {
  }

  open fun updateFooter(vm: VM, isNotify: Boolean = true, position: Int = list.size) {

  }

  //=====================  ==========================

  //===================== init ========================

  override fun onBindViewHolder(holder: BaseKtVH<VM>, position: Int) {
    holder.updateData(list.get(position))
  }

  override fun getItemViewType(position: Int): Int {
    if (list.get(position).index ?: 0 < 0) {
      return 0
    }
    if (list.get(position).viewType > 0 && list.get(position).select.get() == true) {
      return list.get(position).index ?: 0
    }
    else {
      return 0
    }
    return list.get(position).viewType
  }

  override fun getItemCount(): Int = count

  fun update(context: Context, rv: RecyclerView, manager: RecyclerView.LayoutManager): BaseRvAdapter<VM> {
    rv.layoutManager = manager
    rv.adapter = this
    return this
  }

  fun update(list: ArrayList<VM>, index: Int) {
    this.list.addAll(list)
  }
}