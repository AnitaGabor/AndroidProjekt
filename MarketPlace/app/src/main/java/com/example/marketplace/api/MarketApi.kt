package com.example.marketplace.api

import com.example.marketplace.addproduct.model.*
import com.example.marketplace.login.model.*
import com.example.marketplace.timeline.model.*
import com.example.marketplace.register.model.*
import com.example.marketplace.forgetPassword.model.*
import com.example.marketplace.myfare.model.OrderResponse
import com.example.marketplace.mymarket.RemoveResponse
import com.example.marketplace.settingsProfile.model.*
import com.example.marketplace.profile.model.*
import com.example.marketplace.updateProduct.model.UpdateRequest
import com.example.marketplace.updateProduct.model.UpdateResponse
import com.example.marketplace.utils.Constants.Companion.ADD_PRODUCT_URL
import com.example.marketplace.utils.Constants.Companion.GET_ORDERS_URL
import com.example.marketplace.utils.Constants.Companion.GET_PRODUCT_URL
import com.example.marketplace.utils.Constants.Companion.LOGIN_URL
import com.example.marketplace.utils.Constants.Companion.REGISTER_URL
import com.example.marketplace.utils.Constants.Companion.REMOVE_PRODUCT_URL
import com.example.marketplace.utils.Constants.Companion.RESET_URL
import com.example.marketplace.utils.Constants.Companion.UPDATE_DATA_URL
import com.example.marketplace.utils.Constants.Companion.UPDATE_PRODUCT_URL
import com.example.marketplace.utils.Constants.Companion.USER_INFO_URL
import retrofit2.http.*

interface MarketApi {
    @POST(LOGIN_URL)
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @GET(GET_PRODUCT_URL)
    suspend fun getProducts(
        @Header("token") token: String,
        @Header("limit") limit: Int = 550
    ): ProductResponse

    @POST(REGISTER_URL)
    suspend fun register(@Body request: RegisterRequest): RegisterResponse

    @POST(RESET_URL)
    suspend fun reset(@Body request: ResetRequest): ResetResponse

    @POST(UPDATE_DATA_URL)
    suspend fun updateUser(
        @Header("token") token: String,
        @Body request: SettingsRequest
    ): SettingsResponse

    @GET(USER_INFO_URL)
    suspend fun getUserData(@Header("username") username: String): UserResponse

    @Multipart
    @POST(ADD_PRODUCT_URL)
    suspend fun addProduct(
        @Header("token") token: String, @Part("title") title: String?,
        @Part("description") description: String?, @Part("price_per_unit") price_per_unit: String?,
        @Part("units") units: String?
    ): AddProductResponse

    @POST(UPDATE_PRODUCT_URL)
    suspend fun updateProduct(
        @Header("token") token: String,
        @Query("product_id") product_id: String,
        @Body request: UpdateRequest
    ): UpdateResponse

    @POST(REMOVE_PRODUCT_URL)
    suspend fun removeProduct(@Header("token") token: String,
                              @Query("product_id") product_id: String) :RemoveResponse

    @GET(GET_ORDERS_URL)
    suspend fun getOrders(
        @Header("token") token: String,
        @Header("limit") limit: Int = 550
    ): OrderResponse

}