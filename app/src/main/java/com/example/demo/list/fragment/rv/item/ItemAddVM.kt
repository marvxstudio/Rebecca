package com.example.demo.list.fragment.rv.item

import com.example.demo.list.fragment.rv.RvVMBox
import com.example.demo.list.fragment.rv.base.BaseItemVM
import com.rebecca.lib.v.rv.BaseVMRvAdapter

class ItemAddVM : BaseItemVM() {

    lateinit var adapter: BaseVMRvAdapter<RvVMBox>

    //======================
    override fun onClick() {
        super.onClick()
        adapter.add(RvVMBox().set(ItemAddVM().set(adapter).setName(name.get() ?: "")), adapter.getSizeOffset(-1))
    }

    fun set(adapter: BaseVMRvAdapter<RvVMBox>): ItemAddVM {
        this.adapter = adapter
        return this
    }
}