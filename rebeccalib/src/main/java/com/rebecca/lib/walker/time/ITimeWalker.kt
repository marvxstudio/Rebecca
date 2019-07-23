package com.rebecca.lib.walker.time

interface ITimeWalker {

  fun start()

  fun pause()

  interface Watcher {

    fun canKeepWalking(): Boolean

    fun onUpdate()
  }
}