package com.example.demo.list.fragment.rv

import android.view.ViewGroup
import com.example.demo.list.fragment.rv.footer.FunFooterVH
import com.example.demo.list.fragment.rv.header.FunHeaderVH
import com.example.demo.list.fragment.rv.item.FunItemVH
import com.rebecca.lib.v.rv.BaseRvVH
import com.rebecca.lib.v.rv.BaseVMRvAdapter
import com.rebecca.lib.v.rv.VHType

class FunListAdapter : BaseVMRvAdapter<RvVMBox>() {
    //=========================  =================================

    //=========================  =================================

    //========================= main ==================================

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRvVH<*, RvVMBox> {
        val vh: BaseRvVH<*, RvVMBox>
        when (viewType) {
            VHType.HEADER -> {
                vh = FunHeaderVH(parent)
            }
            VHType.FOOTER -> {
                vh = FunFooterVH(parent)
            }
            else -> {
                vh = FunItemVH(parent).set(this)
            }
        }
        return vh
    }
}