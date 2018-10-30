package com.rebecca.lib.http.host

abstract class BaseHost(var ip: String, var portHttp: String = "80", var portHttps: String = "443") {

    //========================================================

    open val urlHttp: String = "$HTTP$ip:$portHttp"

    open val urlHttps: String = "$HTTPS$ip:$portHttps"

    //========================================================
    open var url: String = urlHttps
    open var urlH5: String = "$urlHttp/"

    //========================================================
    companion object {
        const val HTTP = "http://"
        const val HTTPS = "https://"
    }
}