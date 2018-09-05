package com.example.demo.bean

import android.arch.lifecycle.MutableLiveData
import com.example.demo.BaseBean

class RebeccaUser : BaseBean() {
    /*
    * MutableLiveData 替换普通类型
    */
    var userName: MutableLiveData<String> = MutableLiveData() //用户名

    var userPassword: MutableLiveData<String> = MutableLiveData() //密码

    var userInfo: MutableLiveData<String> = MutableLiveData() //信息
}