package com.example.demo.rx

import android.arch.lifecycle.MediatorLiveData
import com.rebecca.lib.zbase.vm.BaseKtVM

class RxVM : BaseKtVM() {

  val text = MediatorLiveData<String>().also { it.value = "RX" }
}