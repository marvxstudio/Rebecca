package com.example.demo.font

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
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
    val obsB = object : Observable.OnPropertyChangedCallback() {
      override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
        Loger.show("obs2= ${sender.toString()}  id= $propertyId")

      }
    }
    addOnPropertyChangedCallback(obsB)
    addOnPropertyChangedCallback(obsB)
  }
  //================= ===================
  var bean5 = MutableLiveData<FTest>()

  var bean6 = MutableLiveData<FTest>().apply { value = FTest() }

  val bean7 = MLDFTest().apply { text.value = "9527" }
  val bean8: OBFTest? = null
  //================= ===================

  data class FTest(var text: String = "9527") {

  }

  class OBFTest {
    val text = ObservableField<String>()
    var k: String? = null
  }

  class MLDFTest {
    val text = MutableLiveData<String>()
  }

  //================= ===================
  protected val obser = Observer<FTest> {
    Loger.show("livedata bean5= ${it?.text}")
  }

  fun addobs(owner: LifecycleOwner) {
    bean5.observe(owner, obser)
  }

  fun removeobs() {
    bean5.removeObserver(obser)
  }

  //==================== ===============
  override fun onCreate(owner: LifecycleOwner): ViewModel {
    addobs(owner)
    return super.onCreate(owner)
  }

  override fun onDestroy(owner: LifecycleOwner) {
    removeobs()

    super.onDestroy(owner)
  }
}
