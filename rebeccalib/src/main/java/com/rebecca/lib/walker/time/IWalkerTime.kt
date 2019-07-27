package com.rebecca.lib.walker.time

interface IWalkerTime {

  fun start()

  fun pause()

//  fun start(per: Long, delay: Long = 0, onUpdate: () -> Unit, onFinish: () -> Unit,
//    canKeepWalking: () -> Boolean = { false }, isNew: Boolean = true): Disposable

  interface Watcher {

    fun canKeepWalking(): Boolean

    fun onUpdate()

    fun onWalkerFinish() {}
  }
}