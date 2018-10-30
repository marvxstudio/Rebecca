package com.rebecca.lib.v.rv

abstract class BaseVMBox<VM : BaseRvVM> : BaseRvVM() {
    //=====================  ======================
    lateinit var vmItem: VM

    //=====================  ======================
    open fun set(vm: VM): BaseVMBox<VM> {
        this.vmItem = vm
        return this
    }
}