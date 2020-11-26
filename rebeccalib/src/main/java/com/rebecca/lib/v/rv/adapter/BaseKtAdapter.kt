package com.rebecca.lib.v.rv.adapter

import android.support.v7.widget.RecyclerView.Adapter
import com.rebecca.lib.v.rv.BaseRvVM
import com.rebecca.lib.v.rv.vh.BaseKtVH

abstract class BaseKtAdapter<VM : BaseRvVM>(protected val list: ArrayList<VM>) : Adapter<BaseKtVH<VM>>() {

  //================================================

  //================================================

  open fun removeType(type: Int): BaseKtAdapter<VM> = this

  fun outputList(): ArrayList<VM> = list

  fun output(index: Int): VM? = null

  //================================================

}