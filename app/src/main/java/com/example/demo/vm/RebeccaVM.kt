package com.example.demo.vm

import android.arch.lifecycle.MutableLiveData
import com.example.demo.bean.RebeccaUser
import com.rebecca.lib.zbase.vm.BaseVM

class RebeccaVM : BaseVM() {

    var bean: MutableLiveData<RebeccaUser> = MutableLiveData()
    //lateinit var bean: RebeccaUser
    //===================================================
    var isLogin: MutableLiveData<Boolean> = MutableLiveData() //是否已登录
    val color = MutableLiveData<Int>()
    //===================================================
    fun showBean() {
//        Log.d(mTag, mTag + " : \r\n" + bean.userName.value + "\r\n" + bean.userPassword.value + "\r\n" + bean.userInfo
//                .value)
    }
    //===================================================
}