package com.rebecca.lib.web

import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient

open class BaseWebCtr : IWebCtr {
  //================= ==================
  protected var webView: WebView? = null
  protected open var openJS: Boolean = true
  //================= ==================

  //================= ==================

  override fun open(url: String) {
    onFixUrl(url)?.let {
      webView?.loadUrl(it)
    }
  }

  //================= ==================

  override fun update(v: WebView, client: WebViewClient, keyListener: View.OnKeyListener): IWebCtr {
    webView = v
    onCreateSetting(v)
    if (openJS) {
      onSubJS(v)
    }
    return super.update(v, client, keyListener)
  }
  //================= ==================

  open protected fun onFixUrl(url: String?): String? {
    return url
  }

  override fun subJS(js: BaseWebJS, type: String) {
    webView?.addJavascriptInterface(js, type)
  }

  //================= ==================
  open protected fun onSubJS(v: WebView) {

  }
  //================= ==================

  open protected fun onCreateSetting(v: WebView) {
    v.settings.javaScriptEnabled = openJS
  }
  //================= ==================

}