package com.example.demo.font

import android.arch.lifecycle.MutableLiveData
import android.databinding.Observable
import android.databinding.ObservableField
import com.rebecca.lib.tools.Loger
import com.rebecca.lib.zbase.vm.BaseVM

class FontVM : BaseVM() {

  //================= ===================
  var bean1 = FTest()

  val bean2 = OBFTest()

  var bean3 = ObservableField<FTest>(FTest())

  var bean4 = ObservableField<FTest>(FTest()).apply {
    addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
      override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
        Loger.show("obs= ${sender.toString()}  id= $propertyId")

      }
    })
    addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
      override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
        Loger.show("obs2= ${sender.toString()}  id= $propertyId")

      }
    })
  }
  //================= ===================
  var bean5 = MutableLiveData<FTest>()

  var bean6 = MutableLiveData<FTest>().apply { value = FTest() }

  val bean7 = MLDFTest().apply { text.value = "9527" }
  //================= ===================

  data class FTest(var text: String = "9527") {

  }

  class OBFTest {
    val text = ObservableField<String>()
  }

  class MLDFTest {
    val text = MutableLiveData<String>()
  }
}