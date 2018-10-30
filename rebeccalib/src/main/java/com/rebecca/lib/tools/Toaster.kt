package com.rebecca.lib.tools

import android.content.Context
import android.widget.Toast

open class Toaster(var context: Context) {

    val toast by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        Toast.makeText(context, "", duration)
    }
    val gravity = toast.gravity
    val offsetX = toast.xOffset
    val offsetY = toast.yOffset
    //    var toastView = lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
//        Toast(context)
//    }
    var duration: Int = Toast.LENGTH_SHORT

    var isDebug: Boolean = true

    //=========================================================

    fun show(msg: Any, isShow: Boolean = isDebug,
             gravity: Int = this.gravity, xOffset: Int = offsetX, yOffset: Int = offsetY) {

        if (isShow) {
            toast.setText(msg.toString())
            toast.duration = duration
            toast.setGravity(gravity, xOffset, yOffset)
            toast.show()
        }
    }

    /*fun showView() {//自定义布局 待实现databinding版
        if(isDebug){

            toastView.value.duration=duration
            toastView.value.show()
        }
    }*/

    //============== set =======================
//    fun setView(v: View): Toaster {
//        toastView.value.view = v
//        return this
//    }

    fun setDuration(duration: Int): Toaster {
        this.duration = duration
        return this
    }

    fun setDebug(isDebug: Boolean): Toaster {
        this.isDebug = isDebug
        return this
    }
}


