package com.rebecca.lib.tools

import android.content.Context
import android.content.pm.ApplicationInfo

interface ILoger {

  //===================== =====================
  var isOpen: Boolean
  var mTag: String

  //===================== =====================
  enum class ModeSync {
    APP_SYNC,
    OPEN,
    CLOSE,
  }

  enum class ModeLog {
    E, D, V, I, W
  }

  //===================== =====================

  //===================== =====================

  //===================== =====================
  fun show(msg: Any, isOpen: Boolean = this.isOpen, tag: String = mTag, mode: ModeLog = ModeLog.D)

  //===================== =====================
  fun update(mode: ModeSync, context: Context? = null): ILoger {
    val flag: Boolean = when (mode) {
      ModeSync.APP_SYNC -> {
        val value = context?.applicationInfo?.flags ?: 0
        value and ApplicationInfo.FLAG_DEBUGGABLE != 0
      }
      ModeSync.OPEN -> {
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