package com.rebecca.lib.tools

import android.content.Context
import android.widget.Toast

open class Toaster(var context: Context) {

    val toast by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        Toast.makeText(context, "", duration)
    }
//    var toastView = lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
//        Toast(context)
//    }
    var duration: Int = Toast.LENGTH_SHORT

    var isDebug: Boolean = true//默认参数isDebug=true 用于普通显示toast , 若作为调试用途 传入isDebug=BuildConfig.DEBUG 即可

    //=========================================================

    fun show(msg: Any, gravity: Int = toast.gravity, xOffset: Int = toast.xOffset, yOffset: Int = toast.yOffset) {
        if (isDebug) {
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


