package com.example.marketplace.api

import com.example.marketplace.addproduct.model.*
import com.example.marketplace.login.model.*
import com.example.marketplace.timeline.model.*
import com.example.marketplace.register.model.*
import com.example.marketplace.forgetPassword.model.*
import com.example.marketplace.settingsProfile.model.*
import com.example.marketplace.profile.model.*
import com.example.marketplace.utils.Constants.Companion.ADD_PRODUCT_URL
import com.example.marketplace.utils.Constants.Companion.GET_PRODUCT_URL
import com.example.marketplace.utils.Constants.Companion.LOGIN_URL
import com.example.marketplace.utils.Constants.Companion.REGISTER_URL
import com.example.marketplace.utils.Constants.Companion.RESET_URL
import com.example.marketplace.utils.Constants.Companion.UPDATE_DATA_URL
import com.example.marketplace.utils.Constants.Companion.USER_INFO
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface MarketApi {
    @POST(LOGIN_URL)
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @GET(GET_PRODUCT_URL)
    suspend fun getProducts(@Header("token") token: String, @Header("limit") limit: Int = 100): ProductResponse

    @POST(REGISTER_URL)
    suspend fun register(@Body request: RegisterRequest): RegisterResponse

    @POST(RESET_URL)
    suspend fun reset(@Body request: ResetRequest) :ResetResponse

    @POST(UPDATE_DATA_URL)
    suspend fun updateUser(@Header("token") token:String, @Body request: SettingsRequest) : SettingsResponse

    @GET(USER_INFO)
    suspend fun getUserData(@Header("username") username:String) :UserResponse

    @POST(ADD_PRODUCT_URL)
    suspend fun addProduct(@Header("token") token:String, @Body request: AddProductRequest) :AddProductResponse


}