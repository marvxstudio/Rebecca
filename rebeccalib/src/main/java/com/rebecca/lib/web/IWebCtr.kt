package com.rebecca.lib.web

import android.os.Build
import android.view.KeyEvent
import android.view.View
import android.view.View.OnKeyListener
import android.webkit.CookieManager
import android.webkit.WebView
import android.webkit.WebViewClient

interface IWebCtr {

  //==================== ===================
  //==================== ===================

  fun open(url: String)

  fun back() {}

  //==================== ===================

  fun update(v: WebView, client: WebViewClient = WebViewClient(), keyListener: OnKeyListener = WebKey(v)): IWebCtr {
    v.let {
      it.webViewClient = client
      it.setOnKeyListener(keyListener)
    }
    return this
  }

  //==================== ===================

  fun subJS(js: BaseWebJS, type: String = js.type)
  //==================== ===================
  fun updateCookie(url: String, cookie: String = "") {
    CookieManager.getInstance().let {
      it.setAcceptCookie(true)
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        it.removeAllCookies { }
      }
      else {
        it.removeAllCookie()
      }
      it.setCookie(url, cookie)
    }
  }
  //==================== ===================

  open class WebKey(val webView: WebView) : OnKeyListener {
    override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
      var flag = false
      webView.let {
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
}