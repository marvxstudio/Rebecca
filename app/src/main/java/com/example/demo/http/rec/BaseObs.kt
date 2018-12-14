package com.example.demo.http.rec

import com.example.demo.http.bean.HttpBox
import com.rebecca.lib.http.bean.BaseHttpBean
import com.rebecca.lib.http.rx.dpobs.BaseVMDpObs

class BaseObs<B : BaseHttpBean> : BaseVMDpObs<HttpBox<B>>() {
    override fun onRec(box: HttpBox<B>) {
        box.isRec()
        box.beanRec.isRec()
    }

    override fun onRecComplete() {
    }

    override fun isNetOn(): Boolean {
        return true
    }
}