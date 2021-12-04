package com.example.marketplace.api

import com.example.marketplace.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val api:MarketApi by lazy {
        retrofit.create(MarketApi :: class.java)
    }
}