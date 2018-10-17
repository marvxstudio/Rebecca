package com.rebecca.lib.tools

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ViewTools {
    companion object {

        //=============== inflater================

        fun inflate(layoutId: Int, vg: ViewGroup?, context: Context = vg!!.context, attachToRoot: Boolean = false): View {
            return LayoutInflater.from(context).inflate(layoutId, vg, attachToRoot)
        }
    }
}