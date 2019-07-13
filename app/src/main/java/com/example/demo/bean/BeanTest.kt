package com.example.demo.bean

import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField

class BeanTest(var name: String = "0", val k: MutableLiveData<String> = MutableLiveData<String>()) {

  val text = ObservableField<String>()
}