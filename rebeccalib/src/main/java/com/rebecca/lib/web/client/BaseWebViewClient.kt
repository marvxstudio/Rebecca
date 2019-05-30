package com.rebecca.lib.web.client

import android.os.Build
import android.support.annotation.RequiresApi
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

open class BaseWebViewClient : WebViewClient() {

  @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
  override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
    request?.url.toString().let {
      view?.loadUrl(it)
    }
    return true
  }
}