package com.rebecca.lib.tools

import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import android.support.v7.widget.RecyclerView

object ToolsList {
  fun <T> createOBS(adapter: RecyclerView.Adapter<*>, list: ObservableArrayList<T>): ObservableArrayList<T> {

    val obs = object : ObservableList.OnListChangedCallback<ObservableArrayList<T>>() {
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
    list.addOnListChangedCallback(obs)
    return list
  }
}