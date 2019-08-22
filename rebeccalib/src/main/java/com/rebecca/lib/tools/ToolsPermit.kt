package com.rebecca.lib.tools

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat

object ToolsPermit {
  val CODE_PM = 1024
  //====================== ===================
  fun open(context: Activity, code: Int = CODE_PM, vararg pmList: String) {
    ActivityCompat.requestPermissions(context, pmList, code)
  }

  fun open(context: Activity, pm: String, onOpen: () -> Unit, code: Int = CODE_PM) {
    if (isPermit(context, pm)) {
      onOpen()
    }
    else {
      ActivityCompat.requestPermissions(context, arrayOf(pm), code)
    }
  }

  //====================== ===================
  fun isPermit(context: Context, pm: String): Boolean {
    return PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(context, pm)
  }

  fun canPermitRequest(context: Activity, pm: String): Boolean {
    return ActivityCompat.shouldShowRequestPermissionRationale(context, pm)
  }

  fun isPermitDisable(context: Activity, pm: String): Boolean {
    return isPermit(context, pm) == false && canPermitRequest(context, pm) == false
  }
}