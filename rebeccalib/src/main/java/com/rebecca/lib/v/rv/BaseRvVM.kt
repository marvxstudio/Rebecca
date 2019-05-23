package com.rebecca.lib.v.rv

import com.rebecca.lib.zbase.vm.BaseVM

abstract class BaseRvVM : BaseVM() {

  //=========================  =================================
  object Index {
    const val NONE = -1
  }

  var index: Int = Index.NONE
  //=========================  =================================
  open var spanPer: Double = 1.0
  //=========================  =================================
  open var viewType: Int = VHType.ITEM

  //=========================  =================================
}