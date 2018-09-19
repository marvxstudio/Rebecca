package com.example.demo.http

import com.rebecca.lib.http.client.BaseHttpClient

object VMClient : BaseHttpClient<RestApi>(Httper) {
    override var clsApi: Class<RestApi> = RestApi::class.java
}