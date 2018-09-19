package com.example.demo.http

import io.reactivex.Observable
import retrofit2.http.POST

interface RestApi {

    @POST("")
    fun s(): Observable<Any>
}