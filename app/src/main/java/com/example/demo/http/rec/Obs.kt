package com.example.demo.http.rec

import com.example.demo.http.bean.HttpBox
import com.rebecca.lib.http.bean.BaseHttpBean
import com.rebecca.lib.http.rx.BaseVMObs

class Obs<B : BaseHttpBean> : BaseVMObs<HttpBox<B>>() {

    override fun onRec(b: HttpBox<B>) {
    }

    override fun isNetOn(): Boolean {
        return true
    }

    override fun isRec(b: HttpBox<B>): Boolean {
        return b.isRec()
    }
}