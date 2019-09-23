package com.example.android_arch_compts_kotlin.network

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val requestBuilder = original.newBuilder()
            .method(original.method(), original.body())
        /*requestBuilder.addHeader(KEY_X_API, SharedPrefsManager.getString(KEY_X_API))
        if (SharedPrefsManager.containsKey(KEY_ACCESS_TOKEN)) {
            requestBuilder.addHeader(KEY_ACCESS_TOKEN, SharedPrefsManager.getString(KEY_ACCESS_TOKEN))
        }
        if (SharedPrefsManager.containsKey(KEY_USER_ID)) {
            requestBuilder.addHeader(KEY_USER_ID, SharedPrefsManager.getString(KEY_USER_ID))
        }*/
        return chain.proceed(requestBuilder.build())
    }
}