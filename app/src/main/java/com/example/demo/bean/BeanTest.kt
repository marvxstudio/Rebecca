package com.example.demo.bean

import android.arch.lifecycle.MutableLiveData

class BeanTest(var name: String = "0", val k: MutableLiveData<String> = MutableLiveData<String>()) {

}