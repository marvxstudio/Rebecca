package com.example.demo.rx

import com.rebecca.lib.zbase.rx.BaseVMObs

interface Obs<B : Any> : BaseVMObs<ArrayList<B>> {

    override fun isRec(b: ArrayList<B>): Boolean {
        return true
    }
}