package com.rebecca.lib.zbase

import android.content.DialogInterface
import android.content.DialogInterface.OnDismissListener
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableEmitter
import io.reactivex.FlowableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

class DialogManager(var fm: FragmentManager, var dialogCountMax: Int = 1) : OnDismissListener {

    val list: ArrayList<DialogFragment> by lazy { ArrayList<DialogFragment>() }
    lateinit var requester: Subscription
    lateinit var poster: FlowableEmitter<DialogFragment>

    fun addDialog(dialog: DialogFragment) {
        onAddDialog(dialog)
        prepareDialogNext()
    }

    fun onAddDialog(dialog: DialogFragment) {
        list.add(dialog)
    }

    fun prepareDialogNext() {
        if (list.size > 0) {
            val df: DialogFragment = list.get(0)
            if (df.dialog == null || df.dialog?.isShowing == false) {
                requester.request(dialogCountMax.toLong())

                poster.onNext(list.get(0))
            }
        }
    }

    val subscriberDialog = object : Subscriber<DialogFragment> {
        override fun onSubscribe(s: Subscription) {
            requester = s
            requester.request(dialogCountMax.toLong())
        }

        override fun onNext(t: DialogFragment?) {
            t?.show(fm, "${list.size}")
        }

        override fun onError(t: Throwable?) {
        }

        override fun onComplete() {
        }
    }

    fun build() {
        Flowable.create(object : FlowableOnSubscribe<DialogFragment> {

            override fun subscribe(emitter: FlowableEmitter<DialogFragment>) {
                poster = emitter
                // poster.onNext(list.get())
            }
        }, BackpressureStrategy.BUFFER)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriberDialog)
    }

    init {
        build()
    }

    override fun onDismiss(dialog: DialogInterface?) {
        list.removeAt(0)
        prepareDialogNext()
    }

    fun onDestory() {
        list.clear()
        requester.cancel()
        poster.onComplete()
    }
}