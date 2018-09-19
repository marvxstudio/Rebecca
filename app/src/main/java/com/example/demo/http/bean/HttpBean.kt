package com.example.demo.http.bean

import com.rebecca.lib.http.bean.BaseHttpBean

class HttpBean : BaseHttpBean() {

    override fun isRec(): Boolean {
        return true
    }
}