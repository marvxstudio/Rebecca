package com.example.demo.http

import com.rebecca.lib.http.client.BaseHttpClient

object VMClient : BaseHttpClient<RestApi>(Httper, RestApi::class.java) {
}