package com.example.demo.font

import android.databinding.ObservableField
import com.rebecca.lib.zbase.vm.BaseVM

class FontVM : BaseVM() {



  //================= ===================
  var bean1 = FTest()

  val bean2 = OBFTest()

  var bean3 = ObservableField<FTest>(FTest())

  var bean4 = ObservableField<FTest>(FTest())
  //================= ===================

  //================= ===================

  class FTest {
    var text = "9527"
  }

  class OBFTest {
    val text = ObservableField<String>()
  }
}