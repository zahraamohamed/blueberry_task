package com.example.prayapp.data


import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("datetime")
    val datetime: List<Datetime>?,
    @SerializedName("location")
    val location: Location?,
    @SerializedName("settings")
    val settings: Settings?
)