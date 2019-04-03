package com.example.demo.rx

import android.arch.lifecycle.MediatorLiveData
import com.rebecca.lib.zbase.vm.BaseVM

class RxVM : BaseVM() {

  val text = MediatorLiveData<String>().also { it.value = "RX" }
}