package com.rebecca.lib.tools

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ViewTools {
    companion object {

        //=============== inflater================

        fun inflate(layoutId: Int, vg: ViewGroup): View {
            return LayoutInflater.from(vg.context).inflate(layoutId, vg, false)
        }
    }
}