package com.rebecca.lib.zbase.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rebecca.lib.zbase.ICreate

abstract class BaseKtActivity : AppCompatActivity(), ICreate {
    //=========================  =================================
    abstract var mLayoutId: Int
    //=========================  =================================
    val mTag = javaClass.simpleName

    open var isDebug = false
    //=========================  =================================

    override fun onInit() {
        onInitView()
        onInitData()
    }

    override fun onInitView() {
    }

    override fun onInitData() {
    }

    //=========================main ==================================
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onInit()
    }
}