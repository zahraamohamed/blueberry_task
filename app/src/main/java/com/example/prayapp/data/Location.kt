package com.example.prayapp.data


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("city")
    val city: String?,
    @SerializedName("country")
    val country: String?,
    @SerializedName("country_code")
    val countryCode: String?,
    @SerializedName("elevation")
    val elevation: Double?,
    @SerializedName("latitude")
    val latitude: Double?,
    @SerializedName("local_offset")
    val localOffset: Double?,
    @SerializedName("longitude")
    val longitude: Double?,
    @SerializedName("timezone")
    val timezone: String?
)