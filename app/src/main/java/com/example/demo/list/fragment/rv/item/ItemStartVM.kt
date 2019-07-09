package com.example.demo.list.fragment.rv.item

import com.example.demo.list.fragment.rv.base.BaseItemVM
import com.rebecca.lib.router.RouterClient
import com.rebecca.lib.v.rv.VHType

class ItemStartVM(override var viewType: Int=VHType.ITEM) : BaseItemVM() {

    lateinit var path: String

    override fun onClick() {
        super.onClick()
        RouterClient.start(path)
    }

    fun setPath(path: String): ItemStartVM {
        this.path = path
        return this
    }
}