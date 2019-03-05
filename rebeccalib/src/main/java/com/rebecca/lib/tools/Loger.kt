package com.rebecca.lib.tools

import android.content.Context
import android.content.pm.ApplicationInfo
import android.util.Log

object Loger {

  //==================== =========================
  enum class Mode {
    APP_SYNC,
    OPEN,
    CLOSE,
  }
  //==================== =========================

  var isOpen = true
  var mTag: String = "++++"

  fun show(msg: Any, isOpen: Boolean = this.isOpen, tag: String = mTag) {
    if (isOpen) {
      Log.d(tag, msg.toString())
    }
  }

  //==================== =========================

  fun update(mode: Mode, context: Context? = null): Loger {
    val flag: Boolean = when (mode) {
      Mode.APP_SYNC -> {
        val value = context?.applicationInfo?.flags ?: 0
        value and ApplicationInfo.FLAG_DEBUGGABLE != 0
      }
      Mode.OPEN -> {
        true
      }
      else -> {
        false
      }

    }
    isOpen = flag
    return this
  }

}