package com.rebecca.lib.http

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.rebecca.lib.http.host.BaseHost
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

abstract class BaseHttper(var host: BaseHost) {

  //=========================  =================================
  protected val mTag = javaClass.simpleName
  //=========================  =================================
  protected val mRetrofit: Retrofit by lazy { onCreateRetrofit() }
  //=========================  =================================

  //========================= gson =================================
  fun onCreateGson(): Gson {
    return GsonBuilder().create()
  }

  //========================= header =================================

  fun onCreateHeader() {
  }

  //========================= retrofit =================================
  open fun onCreateRetrofit(builder: Retrofit.Builder = Retrofit.Builder().baseUrl(host.url)): Retrofit {
    builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create())//设置返回类型为RXJava，或者回调
      .addConverterFactory(GsonConverterFactory.create(onCreateGson()))      //设置返回数据类型
      .client(onCreateOkHttpClient()) //设置网络请求，默认httpclient
    return builder.build()
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
  //=========================  =================================

  fun <API : Any> createApi(cls: Class<API>): API {
    return mRetrofit.create<API>(cls)
  }
  //=========================  =================================
}