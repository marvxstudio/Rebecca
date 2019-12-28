package com.rebecca.lib.tools

import android.util.Log

object Loger : ILoger {

  //==================== =========================

  override var isOpen: Boolean = true
  override var mTag: String = "++++"

  //==================== =========================

  //==================== =========================

  override fun show(msg: Any, isOpen: Boolean, tag: String, mode: ILoger.ModeLog) {
    if (isOpen) {
      when (mode) {
        ILoger.ModeLog.D -> Log.d(tag, msg.toString())
        ILoger.ModeLog.I -> Log.i(tag, msg.toString())
        ILoger.ModeLog.V -> Log.v(tag, msg.toString())
        ILoger.ModeLog.W -> Log.w(tag, msg.toString())
        ILoger.ModeLog.E -> Log.e(tag, msg.toString())
      }
    }
  }

  //==================== =========================

  //==================== =========================
  //==================== =========================

}

fun <T : Any> T.showLog(msg: Any = this, isOpen: Boolean = Loger.isOpen, tag: String = Loger.mTag, mode: ILoger.ModeLog = ILoger.ModeLog.D): T {
  Loger.show(msg, isOpen, tag, mode)
  return this
}