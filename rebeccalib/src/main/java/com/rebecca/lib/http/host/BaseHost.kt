package com.rebecca.lib.http.host

abstract class BaseHost(var ip: String, var portHttp: String = "80", var portHttps: String = "443", val urlHttp: String =
  "$HTTP$ip:$portHttp", val urlHttps: String = "$HTTPS$ip:$portHttps") {

  //========================================================

  //========================================================
  open var url: String = urlHttps
  open var urlH5: String = "$urlHttp/"

  //========================================================
  companion object {
    const val HTTP = "http://"
    const val HTTPS = "https://"
  }
}