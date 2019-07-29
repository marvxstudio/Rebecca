package com.rebecca.lib.tools

import android.content.Context
import android.content.pm.ApplicationInfo
import android.view.Window
import android.view.WindowManager

object ToolsApp {
  fun isAppDebug(context: Context): Boolean {

    val value = context.applicationInfo.flags
    return value and ApplicationInfo.FLAG_DEBUGGABLE != 0
  }

  fun updateScreen(window: Window, keepOpen: Boolean) {
    val flag = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
    window.let {
      if (keepOpen) {
        it.addFlags(flag)
      }
      else {
        it.clearFlags(flag)
      }
    }
  }
}