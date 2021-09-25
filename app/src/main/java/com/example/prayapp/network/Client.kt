package com.example.prayapp.network

import android.util.Log
import com.example.prayapp.data.PrayData
import com.example.prayapp.ui.Status
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

object Client {

    //make first request

    private val okHttpClient = OkHttpClient()
    private val urlokhttp = "https://api.pray.zone/v2/times/today.json?"
    private val gson = Gson()

    fun initRequest(city: String): Status<PrayData> {

        Log.i("mega", "make Request")

        val request = Request.Builder().url("${urlokhttp}city=$city").build()
        val response = okHttpClient.newCall(request).execute()

        return if (response.isSuccessful) {
            val parserResponse = gson.fromJson(
                response.body?.string(),
                PrayData::class.java
            )
            Status.Success(parserResponse)
        } else {
            Status.Error(response.message)
        }
    }










    
}