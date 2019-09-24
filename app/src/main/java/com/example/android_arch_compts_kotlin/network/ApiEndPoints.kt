package com.example.android_arch_compts_kotlin.network

import com.example.android_arch_compts_kotlin.model.AboutUsModel
import com.example.android_arch_compts_kotlin.model.ResponseData
import com.example.android_arch_compts_kotlin.model.UserModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

const val GENERATE_KEY_URL = "key"
const val SIGN_IN_URL = "signin"
const val ABOUT_US_URL = "fda9a"
const val USER_LIST_URL = "bjwyg"

interface ApiEndPoints {
    @POST(GENERATE_KEY_URL)
    fun getKey(): Call<ResponseData<String>>

    @FormUrlEncoded
    @POST(SIGN_IN_URL)
    fun singInService(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("device_token") deviceToken: String
    ): Call<ResponseData<UserModel>>

    @GET(ABOUT_US_URL)
    fun aboutUsService(): Call<ResponseData<AboutUsModel>>

    @GET(USER_LIST_URL)
    fun getUserList(): Call<ResponseData<ArrayList<UserModel>>>
}