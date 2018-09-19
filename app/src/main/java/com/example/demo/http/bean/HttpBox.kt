package com.example.demo.http.bean

import com.rebecca.lib.http.bean.BaseHttpBean
import com.rebecca.lib.http.bean.BaseHttpBox

class HttpBox<B : BaseHttpBean> : BaseHttpBox() {

    lateinit var beanRec: B
    //=============================

    override fun isRec(): Boolean {
        return true
    }
}