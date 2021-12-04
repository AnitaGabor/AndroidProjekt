package com.example.marketplace.api

import com.example.marketplace.models.LoginRequest
import com.example.marketplace.models.LoginResponse
import com.example.marketplace.models.ProductResponse
import com.example.marketplace.utils.Constants.Companion.GET_PRODUCT_URL
import com.example.marketplace.utils.Constants.Companion.LOGIN_URL
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface MarketApi {
    @POST(LOGIN_URL)
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @GET(GET_PRODUCT_URL)
    suspend fun getPost(@Header("token") token: String): ProductResponse


}