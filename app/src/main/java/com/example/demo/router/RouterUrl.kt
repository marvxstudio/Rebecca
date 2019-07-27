package com.example.demo.router

class RouterUrl {

  companion object {
    private const val ACTIVITY = "Activity"
    private const val FRAGMENT = "Fragment"

    const val NONE = ""//无跳转目标 可以选择finish当前界面
  }

  object App {
    private const val model = "/app/"
    const val COMMON = model + "common" + ACTIVITY
    const val DIALOG = model + "dialog" + ACTIVITY
    const val RX = model + "RX" + ACTIVITY
    const val Font = model + "font" + ACTIVITY
    const val Web = model + "Web" + ACTIVITY
    const val Routine = model + "Routine" + ACTIVITY
  }
}