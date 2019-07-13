package com.example.demo.update

import android.databinding.ObservableField
import com.example.demo.bean.BeanTest
import com.rebecca.lib.zbase.vm.BaseVM

class UpdateBeanVM : BaseVM() {
  var bean = ObservableField<BeanTest>()

}