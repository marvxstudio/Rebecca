package com.rebecca.lib.zbase.vm

import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.RequestBody.create

abstract class BaseVMModel {
    open fun <T : Any> sub(t: Observable<T>): Observable<T> {

        return t.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

    open fun createBody(map: Map<String, Any>): RequestBody {
        val json: String = Gson().toJson(map)
        val body: RequestBody = create(MediaType.parse("application/json;charset=UTF-8"), json)
        return body
    }
}