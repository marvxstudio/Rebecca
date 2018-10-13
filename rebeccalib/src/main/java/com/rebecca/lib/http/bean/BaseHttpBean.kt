package com.rebecca.lib.http.bean

abstract class BaseHttpBean : ICheck {

    override fun isRec(): Boolean {
        return true
    }
}