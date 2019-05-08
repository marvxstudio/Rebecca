package com.example.demo.font

import android.arch.lifecycle.MutableLiveData
import com.example.demo.bean.BeanTest
import com.rebecca.lib.zbase.vm.BaseVM

class FontVM : BaseVM() {

  val s by lazy { "1234567890" }

  val bean = MutableLiveData<BeanTest>().also { it.value = BeanTest() }

}