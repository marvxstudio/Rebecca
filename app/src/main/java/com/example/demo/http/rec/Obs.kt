package com.example.demo.http.rec

import com.example.demo.http.bean.HttpBox
import com.rebecca.lib.http.bean.BaseHttpBean
import com.rebecca.lib.http.rx.BaseVMObs

class Obs<B : BaseHttpBean> : BaseVMObs<HttpBox<B>>() {

    override fun onRec(box: HttpBox<B>) {
        box.isRec()
        box.beanRec.isRec()
    }

    override fun isNetOn(): Boolean {
        return true
    }
}