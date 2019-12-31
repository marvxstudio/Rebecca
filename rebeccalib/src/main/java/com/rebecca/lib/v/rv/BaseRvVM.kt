package com.rebecca.lib.v.rv

import android.databinding.ObservableBoolean
import com.rebecca.lib.zbase.vm.BaseKtVM

abstract class BaseRvVM : BaseKtVM() {

  //=========================  =================================

  var index: Int? = null
  //=========================  =================================
  val select by lazy { ObservableBoolean(false) }
  //=========================  =================================
  open var spanPer: Double = 1.0
  //=========================  =================================
  open var viewType: Int = 0
  //=========================  =================================
}