package com.example.demo.dialog.vm

import android.arch.lifecycle.MutableLiveData
import com.rebecca.lib.zbase.vm.BaseKtVM

class MaterialDialogVM : BaseKtVM() {
    var title: MutableLiveData<String> = MutableLiveData()

    var info: MutableLiveData<String> = MutableLiveData()

    var age: String? = null
}