package com.rebecca.lib.web

import android.webkit.JavascriptInterface

abstract class BaseWebJS(val type: String) {

  @JavascriptInterface
  abstract fun onRecJS(json: String)
}