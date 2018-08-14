package com.example.demo.list.fragment.rv

import android.view.ViewGroup
import com.example.demo.list.fragment.rv.vh.FunFooterVH
import com.example.demo.list.fragment.rv.vh.FunHeaderVH
import com.example.demo.list.fragment.rv.vh.FunItemVH
import com.rebecca.lib.v.rv.BaseRvAdapter
import com.rebecca.lib.v.rv.BaseRvVH

class FunListAdapter : BaseRvAdapter<FunItemVM>() {
    //=========================  =================================

    //=========================  =================================

    //========================= main ==================================

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRvVH<*, FunItemVM> {
        val vh: BaseRvVH<*, FunItemVM>
        when (viewType) {
            HEADER -> {
                vh = FunHeaderVH(parent)
            }
            FOOTER -> {
                vh = FunFooterVH(parent)
            }
            else -> {
                vh = FunItemVH(parent)
            }
        }
        return vh
    }
}