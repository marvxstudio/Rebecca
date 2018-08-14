package com.rebecca.lib.tools

import android.content.Context
import android.view.View
import android.widget.Toast

class Toaster(var context: Context) {

    var toast = lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        Toast.makeText(context, "", duration)
    }
    var toastView = lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        Toast(context)
    }
    var duration: Int = Toast.LENGTH_SHORT

    var isDebug: Boolean = true//默认参数isDebug=true 用于普通显示toast , 若作为调试用途 传入isDebug=BuildConfig.DEBUG 即可

    //=========================================================

    fun show(msg: Any) {
        if (isDebug) {
            toast.value.setText(msg.toString())
            toast.value.duration = duration
            toast.value.show()
        }
    }

    /*fun showView() {//自定义布局 待实现databinding版
        if(isDebug){

            toastView.value.duration=duration
            toastView.value.show()
        }
    }*/

    //============== set =======================
    fun setView(v: View): Toaster {
        toastView.value.view = v
        return this
    }

    fun setDuration(duration: Int): Toaster {
        this.duration = duration
        return this
    }

    fun setDebug(isDebug: Boolean): Toaster {
        this.isDebug = isDebug
        return this
    }
}


