package com.example.android_arch_compts_kotlin.network

import com.example.android_arch_compts_kotlin.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private val httpHeaderInterceptor = HeaderInterceptor()
    private val httpLogginInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val apiEndPoints: ApiEndPoints
    private val httpClient = OkHttpClient.Builder()

    init {
        val gson = GsonBuilder().setLenient().create()
        addInterceptors()
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient.build())
            .build()
        apiEndPoints = retrofit.create(ApiEndPoints::class.java)
    }

    private fun addInterceptors() {
        if( !httpClient.interceptors().contains(httpHeaderInterceptor)){
            httpClient.addInterceptor(httpHeaderInterceptor)
        }
        
        if( BuildConfig.DEBUG && !httpClient.interceptors().contains(httpLogginInterceptor)){
            httpClient.addInterceptor(httpLogginInterceptor)    
        }
        
    }

    fun getApiEndPoints() : ApiEndPoints{
        return apiEndPoints
    }
}