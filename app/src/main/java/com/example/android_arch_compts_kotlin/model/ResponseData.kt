package com.example.android_arch_compts_kotlin.model

import com.example.android_arch_compts_kotlin.network.Status
import com.google.gson.annotations.SerializedName


data class ResponseData<T>(

    @SerializedName("MESSAGE")
        var message: String? = "",
    @SerializedName("SUCCESS")
        var success: Int = 0,
    @SerializedName("DATA")
        var data: T?,
    @SerializedName("STATUS")
        var status: Status,
    var key: String? = ""

) {
    companion object {
        fun <T> success(data: ResponseData<T>?): ResponseData<T> {
            return if (data is ResponseData<T>) {
                data.status = Status.SUCCESS
                data
            } else {
                error("Data not Available", null)
            }
        }

        fun <T> error(msg: String, data: T?): ResponseData<T> {
            return ResponseData(message = msg, data = data, status = Status.ERROR)
        }

        fun <T> loading(data: T?): ResponseData<T> {
            return ResponseData(data = data, status = Status.LOADING)
        }
    }
}