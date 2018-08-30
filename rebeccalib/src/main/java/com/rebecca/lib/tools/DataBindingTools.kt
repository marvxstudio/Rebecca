package com.rebecca.lib.tools

import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView

class DataBindingTools {
    companion object {

        @BindingAdapter("android:src")
        @JvmStatic
        fun load(v: ImageView, resId: Int) {
            v.setImageResource(resId)
        }

        @BindingAdapter("android:background")
        @JvmStatic
        fun load(v: View, resId: Int) {
            v.setBackgroundResource(resId)
        }

        @BindingAdapter("android:background")
        @JvmStatic
        fun loadColor(v: View, resId: Int) {
            v.setBackgroundColor(resId)
        }
    }
}