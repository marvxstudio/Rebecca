package com.rebecca.lib.tools

import android.app.Activity
import android.view.View

open class ViewHunter<V : View>(var activity: Activity) {

    fun createView(id: Int): V? {
        val v: V? = activity.findViewById(id) as V?
        if (v != null) {
            onCreateView(v)
        }
        return v
    }

//    fun <T : View> createView(id: Int): T? {
//        val v: T? = activity.findViewById(id) as T?
//        if (v != null) {
//            //onCreateView(v)
//        }
//        return v
//    }

    open fun onCreateView(v: V): V {
        return v
    }
}