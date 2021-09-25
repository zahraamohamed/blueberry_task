package com.example.prayapp.data


import com.google.gson.annotations.SerializedName

data class Times(
    @SerializedName("Asr")
    val asr: String?,
    @SerializedName("Dhuhr")
    val dhuhr: String?,
    @SerializedName("Fajr")
    val fajr: String?,
    @SerializedName("Imsak")
    val imsak: String?,
    @SerializedName("Isha")
    val isha: String?,
    @SerializedName("Maghrib")
    val maghrib: String?,
    @SerializedName("Midnight")
    val midnight: String?,
    @SerializedName("Sunrise")
    val sunrise: String?,
    @SerializedName("Sunset")
    val sunset: String?
)