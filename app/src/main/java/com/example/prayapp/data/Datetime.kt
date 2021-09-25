package com.example.prayapp.data


import com.google.gson.annotations.SerializedName

data class Datetime(
    @SerializedName("date")
    val date: Date?,
    @SerializedName("times")
    val times: Times?
)