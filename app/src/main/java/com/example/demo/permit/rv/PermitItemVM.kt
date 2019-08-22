package com.example.demo.permit.rv

import com.rebecca.lib.v.rv.BaseRvVM

class PermitItemVM : BaseRvVM() {
  //================= ===================
  var name: String = ""
  var pmList: Array<String>? = null

  //================= ===================
  var watcher: Watcher? = null

  //================= ===================

  //================= ===================
  interface Watcher {
    fun onOpen(vararg pmList: String)

    fun onCheck(pm: String)
  }
}