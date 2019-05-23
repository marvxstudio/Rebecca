package com.rebecca.lib.v.rv.adapter

import android.databinding.ObservableArrayList
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.rebecca.lib.v.rv.BaseRvVM

abstract class BasePercentAdapter<VM : BaseRvVM>(list: ObservableArrayList<VM>) : BaseKtAdapter<VM>(list) {

  //======================= ========================

  //======================= ========================
  override fun onAttachedToRecyclerView(rv: RecyclerView) {
    super.onAttachedToRecyclerView(rv)
    val lm = rv.layoutManager
    if (lm is GridLayoutManager) {
      lm.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
        override fun getSpanSize(position: Int): Int {
          return onFixSpan(list[position].spanPer, lm.spanCount)
        }
      }
    }
  }

  open protected fun onFixSpan(spanPer: Double, spanCount: Int): Int {
    val spanItem = (spanPer * spanCount).toInt()

    return when (spanItem) {
      in 1..spanCount -> spanItem

      else -> spanCount
    }
  }

}