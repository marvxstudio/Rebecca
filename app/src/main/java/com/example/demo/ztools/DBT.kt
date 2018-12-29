package com.example.demo.ztools

import android.databinding.BindingAdapter
import android.support.v4.content.ContextCompat
import android.widget.TextView

object DBT {
    @BindingAdapter("app:textcolor")
    @JvmStatic
    fun load(v: TextView, resId: Int) {
        v.setTextColor(ContextCompat.getColor(v.context, resId))
    }
}