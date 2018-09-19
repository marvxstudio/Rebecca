package com.rebecca.lib.http

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.rebecca.lib.http.host.BaseHost
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

abstract class BaseHttper(var host: BaseHost) {

    val mRetrofit: Retrofit by lazy { onCreateRetrofit() }
    //=========================  =================================
    open var isHttps = false

    //=========================  =================================

    fun <API : Any> createApi(cls: Class<API>): API {
        return mRetrofit.create<API>(cls)
    }

    //========================= gson =================================
    fun onCreateGson(): Gson {
        return GsonBuilder().create()
    }
    //========================= okHttp =================================

    fun onCreateOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder().build()

//        val mRewriteCacheControlInterceptor = object : Interceptor {
//            override fun intercept(chain: Interceptor.Chain): Response {
//                var request = chain.request()
//
//                val updateRequest: Request
//                if (NetUtils.isNetworkAvailable()) {
//                    // 有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
//                    val cacheControl = request.cacheControl().toString()
//                    updateRequest = request.newBuilder()
//                            .header("Cache-Control", cacheControl)
//                            .header("Content-Type", "application/json; charset=UTF-8")
//                            .header("imei", HeaderUtils.getIMEI())
//                            .header("client", HeaderUtils.getPlatform())
//                            .header("version", HeaderUtils.getVersionName())
//                            .header("token", getToken())
//                            .build()
//                }
//            }
//        }

        return client
    }
    //========================= header =================================

    fun onCreateHeader() {
    }

    //========================= retrofit =================================
    fun onCreateRetrofit(): Retrofit {
        val url = if (isHttps == false) host.urlHttp else host.urlHttps
        val retrofit = Retrofit.Builder()
                // 设置url头  ：http:www.shianyunduan.com   BuildConfig.API_HOST_URL
                .baseUrl(url)
                //设置返回类型为RXJava，或者回调
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //设置返回数据类型
                .addConverterFactory(GsonConverterFactory.create(onCreateGson()))
                //设置网络请求，默认httpclient
                .client(onCreateOkHttpClient())
                .build()
        return retrofit
    }
    //========================= init  =================================

    //========================= main ==================================

}