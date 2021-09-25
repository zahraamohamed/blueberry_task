package com.example.prayapp.data


import com.google.gson.annotations.SerializedName

data class PrayData(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("results")
    val results: Results?,
    @SerializedName("status")
    val status: String?
)