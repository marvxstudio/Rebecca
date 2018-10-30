package com.rebecca.lib.http.client

import com.rebecca.lib.http.BaseHttper

abstract class BaseHttpClient<API : Any>(httper: BaseHttper, var clsApi: Class<API>) {

    val api: API = httper.createApi(clsApi)
}