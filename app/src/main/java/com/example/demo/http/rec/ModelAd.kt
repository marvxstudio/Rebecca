package com.example.demo.http.rec

import com.example.demo.http.bean.BeanHttp
import com.example.demo.http.bean.HttpBox
import com.rebecca.lib.zbase.vm.BaseVMModel
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class ModelAd : BaseVMModel() {

    val o = object : Observer<BeanHttp> {
        override fun onComplete() {
        }

        override fun onSubscribe(d: Disposable?) {
        }

        override fun onNext(value: BeanHttp?) {
        }

        override fun onError(e: Throwable?) {
        }
    }

    fun k(): Observable<HttpBox<BeanHttp>> {
        val s = Observable.create(object : ObservableOnSubscribe<HttpBox<BeanHttp>> {
            override fun subscribe(e: ObservableEmitter<HttpBox<BeanHttp>>?) {
            }
        })
        return s
    }

    fun applyLoanPage(obs: BaseObs<BeanHttp>) {

        val map = HashMap<String, Any>()
        sub(k(), obs)
    }
}