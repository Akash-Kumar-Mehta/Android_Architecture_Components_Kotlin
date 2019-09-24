package com.example.android_arch_compts_kotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class AboutUsModel (
        @SerializedName("title")
    @Expose
        var title: String?,
        @SerializedName("content")
    @Expose
        var content: String?
)
