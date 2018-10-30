package com.rebecca.lib.router

import android.os.Bundle
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.launcher.ARouter

object RouterClient {

    fun build(path: String): Postcard {
        return ARouter.getInstance().build(path)
    }

    fun start(path: String, bundle: Bundle? = null) {
        start(ARouter.getInstance().build(path).with(bundle))
    }

    fun start(build: Postcard?) {
        build?.navigation()
    }

//    fun start(path: String, model: String){
//        start(model+path)
//    }.navigation()
}