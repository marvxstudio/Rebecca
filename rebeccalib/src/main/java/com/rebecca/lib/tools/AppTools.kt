package com.rebecca.lib.tools

import android.content.Context
import android.content.pm.ApplicationInfo

object AppTools {
  fun isAppDebug(context: Context): Boolean {

    val value = context.applicationInfo.flags
    return value and ApplicationInfo.FLAG_DEBUGGABLE != 0
  }
}