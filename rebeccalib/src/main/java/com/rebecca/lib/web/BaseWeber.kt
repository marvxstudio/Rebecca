package com.rebecca.lib.web

import android.annotation.SuppressLint
import android.view.KeyEvent
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.rebecca.lib.web.client.BaseWebViewClient

open class BaseWeber : IWebCtr, View.OnKeyListener {
  //================= ==================
  var webView: WebView? = null
  open protected var openJS: Boolean = false
  //================= ==================

  open fun open(url: String) {
    onFixUrl(url)?.let {
      webView?.loadUrl(it)
    }
  }

  //================= ==================
  open fun update(webView: WebView, client: WebViewClient? = onCreateWebViewClient(), chromeClient: WebChromeClient? = onCreateWebChromeClient()): BaseWeber {
    webView.let {
      onCreateWebSettings(it.settings)
      it.webViewClient = client
      it.webChromeClient = chromeClient
      this.webView = it
      onUpdateWebView(it)
      it.setOnKeyListener(this)
    }
    if (openJS) {
      onSubJS()
    }
    return this
  }
  //================= ==================

  open protected fun onFixUrl(url: String?): String? {
    return url
  }

  open protected fun onSubJS() {

  }

  @SuppressLint("JavascriptInterface")
  open protected fun subJS(js: BaseWebJS, type: String = js.type) {
    webView?.addJavascriptInterface(js, type)
  }

  //================= ==================
  open protected fun onCreateWebViewClient(): WebViewClient? = BaseWebViewClient()

  open protected fun onCreateWebChromeClient(): WebChromeClient? = null

  open protected fun onCreateWebSettings(settings: WebSettings): WebSettings {
    settings.let {
      it.javaScriptEnabled = openJS
    }
    return settings
  }

  //================= ==================
  open protected fun onUpdateWebView(v: WebView) {

  }

  //================= ==================
  abstract class BaseWebJS(val type: String) {

  }

  override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
    var flag = false
    webView?.let {
      if (v == it) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event?.action == KeyEvent.ACTION_UP) {
          if (it.canGoBack()) {
            it.goBack()
            flag = true
          }
        }
      }
    }
    return flag
  }
}