package com.rebecca.lib.v.rv

import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import android.support.v7.widget.RecyclerView

open class BaseListWatcher<T>(val adapter: RecyclerView.Adapter<*>) : ObservableList.OnListChangedCallback<ObservableArrayList<T>>() {

  //=======================   ============================
  open fun update(list: ObservableArrayList<T>) {
    list.addOnListChangedCallback(this)
  }

  //=======================   ============================
  open fun onUpdate(list: ObservableArrayList<T>, isEmpty: Boolean = list.isEmpty()) {

  }

  //======================= main ============================
  override fun onChanged(sender: ObservableArrayList<T>?) {
    adapter.notifyDataSetChanged()
  }

  override fun onItemRangeRemoved(sender: ObservableArrayList<T>?, positionStart: Int, itemCount: Int) {
    adapter.notifyItemRangeRemoved(positionStart, itemCount)
  }

  override fun onItemRangeMoved(sender: ObservableArrayList<T>?, fromPosition: Int, toPosition: Int, itemCount: Int) {
    if (itemCount == 1) {
      adapter.notifyItemMoved(fromPosition, toPosition)
    }
    else {
      adapter.notifyDataSetChanged()
    }
  }

  override fun onItemRangeInserted(sender: ObservableArrayList<T>?, positionStart: Int, itemCount: Int) {
    adapter.notifyItemRangeInserted(positionStart, itemCount)
  }

  override fun onItemRangeChanged(sender: ObservableArrayList<T>?, positionStart: Int, itemCount: Int) {
    adapter.notifyItemRangeChanged(positionStart, itemCount)
  }
}