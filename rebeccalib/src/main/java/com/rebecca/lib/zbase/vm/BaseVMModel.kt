package com.rebecca.lib.zbase.vm

import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.RequestBody.create

abstract class BaseVMModel {

    open var mediaTypeParse = "application/json;charset=UTF-8"

    open fun <T : Any> sub(t: Observable<T>): Observable<T> {

        return t.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

    open fun <T : Any> sub(t: Observable<T>, obs: Observer<T>) {

        sub(t).subscribe(obs)
    }

    open fun <T : Any, OBS : DisposableObserver<T>> sub(t: Observable<T>, obs: OBS): OBS {

        return sub(t).subscribeWith(obs)
    }

    open fun createBody(map: Map<String, Any>): RequestBody {
        val json: String = Gson().toJson(map)
        val body: RequestBody = create(MediaType.parse(mediaTypeParse), json)
        return body
    }
}