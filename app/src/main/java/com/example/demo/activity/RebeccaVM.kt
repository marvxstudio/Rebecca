package com.example.demo.activity

import android.arch.lifecycle.MutableLiveData
import com.example.demo.R
import com.example.demo.bean.RebeccaUser
import com.rebecca.lib.zbase.vm.BaseKtVM

class RebeccaVM : BaseKtVM() {

    var bean: MutableLiveData<RebeccaUser> = MutableLiveData()
    //lateinit var bean: RebeccaUser
    //===================================================
    var isLogin: MutableLiveData<Boolean> = MutableLiveData() //是否已登录
    val color = MutableLiveData<Int>()
    //===================================================
    var colorCount = 0

    //===================================================
    fun showBean() {

//        Log.d(mTag, mTag + " : \r\n" + bean.userName.value + "\r\n" + bean.userPassword.value + "\r\n" + bean.userInfo
//                .value)
    }

    fun cc(colorCount: Int): Int {
        var color = 0
        var state = colorCount + 1
        state %= 2
        if (state > 0) {
            color = R.color.blue
        }
        else {
            color = R.color.red_pressed
        }
        this.colorCount = state
        return color
    }
    //===================================================
}