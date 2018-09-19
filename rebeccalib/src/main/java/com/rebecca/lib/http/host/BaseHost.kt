package com.rebecca.lib.http.host

abstract class BaseHost {

    abstract var ip: String
    abstract var port: String
    //========================================================
    open var urlHttp: String = "$HTTP$ip:$port"
    open var urlHttps: String = "$HTTPS$ip:$port"

    //========================================================
    companion object {

        const val HTTP = "http://"
        const val HTTPS = "https://"
    }
}