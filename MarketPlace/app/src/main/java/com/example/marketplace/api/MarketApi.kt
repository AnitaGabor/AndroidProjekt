package com.example.marketplace.api

import com.example.marketplace.models.*
import com.example.marketplace.utils.Constants.Companion.GET_PRODUCT_URL
import com.example.marketplace.utils.Constants.Companion.LOGIN_URL
import com.example.marketplace.utils.Constants.Companion.REGISTER_URL
import com.example.marketplace.utils.Constants.Companion.RESET_URL
import com.example.marketplace.utils.Constants.Companion.UPDATE_DATA_URL
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface MarketApi {
    @POST(LOGIN_URL)
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @GET(GET_PRODUCT_URL)
    suspend fun getPost(@Header("token") token: String): ProductResponse

    @POST(REGISTER_URL)
    suspend fun register(@Body request: RegisterRequest): RegisterResponse

    @POST(RESET_URL)
    suspend fun reset(@Body request: ResetRequest) :ResetResponse

    @POST(UPDATE_DATA_URL)
    suspend fun updateUser(@Body request: SettingsRequest) : SettingsResponse


}