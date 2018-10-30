package com.example.demo.list.fragment.rv.item

import android.content.Context
import android.content.Intent
import com.example.demo.list.fragment.rv.base.BaseItemVM

class ItemStartVM : BaseItemVM() {

    lateinit var intent: Intent

    override fun onClick() {
        super.onClick()

    }

    fun setIntent(i: Intent): ItemStartVM {
        intent = i
        return this
    }

    fun start(context: Context) {
        context.startActivity(intent)
    }
}