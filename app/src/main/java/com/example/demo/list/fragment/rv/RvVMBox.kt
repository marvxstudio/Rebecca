package com.example.demo.list.fragment.rv

import com.example.demo.list.fragment.rv.base.BaseItemVM
import com.rebecca.lib.v.rv.BaseVMBox
import com.rebecca.lib.v.rv.VHType

class RvVMBox(override var viewType: Int = VHType.ITEM) : BaseVMBox<BaseItemVM>() {
    //=====================  ======================

    override fun set(vm: BaseItemVM): RvVMBox {
        return super.set(vm) as RvVMBox
    }
}