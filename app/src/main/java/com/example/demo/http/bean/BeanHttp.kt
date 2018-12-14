package com.example.demo.http.bean

import com.rebecca.lib.http.bean.BaseHttpBean
import com.rebecca.lib.http.bean.ICheck

class BeanHttp : BaseHttpBean() ,ICheck{

    override fun isRec(): Boolean {
        return true
    }
}