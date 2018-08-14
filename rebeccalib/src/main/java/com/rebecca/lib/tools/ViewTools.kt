package com.rebecca.lib.tools

import android.databinding.BindingAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class ViewTools {
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

        //=============== inflater================
        fun inflate(layoutId: Int, vg: ViewGroup): View {
            return LayoutInflater.from(vg.context).inflate(layoutId, vg, false)
        }
    }
}