package com.example.demo.rx

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.demo.R
import com.example.demo.databinding.RxActivityBinding
import com.example.demo.router.RouterUrl
import com.rebecca.lib.tools.Loger
import com.rebecca.lib.zbase.activity.BaseVMActivity
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

@Route(path = RouterUrl.App.RX)
class RxActivity(override var mLayoutId: Int = R.layout.rx_activity) : BaseVMActivity<RxActivityBinding, RxVM>() {
    //=========================  =================================
    class And {
        lateinit var peo: Peo
    }

    class Peo {
        lateinit var msg: String
    }
    //=========================  =================================

    fun rxStart() {
        val observable = Observable.create(object : ObservableOnSubscribe<And> {
            override fun subscribe(emitter: ObservableEmitter<And>) {
                var k: And? = And()
                k?.peo = Peo()
                emitter.onNext(k!!)
            }
        })
        observable.subscribe(object : Observer<And> {
            override fun onComplete() {
                Loger.show("complete")
            }

            override fun onError(e: Throwable) {
                Loger.show("error= " + e.toString())
            }

            override fun onNext(t: And) {
                var i = 1
                var kk = ++i
                Loger.show("onNext 1step= $kk")
                Loger.show("onNext= $kk=" + t.peo.msg)
                Loger.show("onNext 2step= $kk")
            }

            override fun onSubscribe(d: Disposable) {
            }
        })
    }
    //========================= init  =================================

    override fun onCreateVM(vm: RxVM): RxVM {
        return super.onCreateVM(vm)
    }

    override fun onInitView() {
        super.onInitView()
        rxStart()
    }
    //========================= main ==================================

}