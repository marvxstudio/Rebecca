package com.rebecca.lib.tools

import android.util.Log

object Loger {

    var isDebug = true
    var mTag: String = "++++"

    fun show(msg: Any, debug: Boolean = isDebug, tag: String = mTag) {
        if (debug) {
            Log.d(mTag, msg.toString())
        }
    }

//    fun show(msg: Any, debug: Boolean = isDebug, tag: String = mTag) {
//        show(msg.toString(), debug, tag)
//    }
}