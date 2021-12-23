package com.example.marketplace.repository

import com.example.marketplace.addproduct.model.*
import com.example.marketplace.api.RetrofitInstance
import com.example.marketplace.timeline.model.*
import com.example.marketplace.login.model.*
import com.example.marketplace.register.model.*
import com.example.marketplace.forgetPassword.model.*
import com.example.marketplace.myfare.model.OrderResponse
import com.example.marketplace.mymarket.RemoveResponse
import com.example.marketplace.settingsProfile.model.*
import com.example.marketplace.profile.model.*
import com.example.marketplace.updateProduct.model.UpdateRequest
import com.example.marketplace.updateProduct.model.UpdateResponse
import retrofit2.http.Part

class Repository {
    suspend fun getProducts(token: String, limit: Int): ProductResponse {
        return RetrofitInstance.api.getProducts(token, limit)
    }

    suspend fun login(request: LoginRequest): LoginResponse {
        return RetrofitInstance.api.login(request)
    }

    suspend fun register(request: RegisterRequest): RegisterResponse {
        return RetrofitInstance.api.register(request)
    }

    suspend fun reset(request: ResetRequest): ResetResponse {
        return RetrofitInstance.api.reset(request)
    }

    suspend fun updateUser(token: String, request: SettingsRequest): SettingsResponse {
        return RetrofitInstance.api.updateUser(token, request)
    }

    suspend fun getUserData(username: String): UserResponse {
        return RetrofitInstance.api.getUserData(username)
    }

    suspend fun addProduct(
        token: String, title: String?, description: String?, price_per_unit: String?,
        units: String?
    ): AddProductResponse {
        return RetrofitInstance.api.addProduct(token, title, description, price_per_unit, units)
    }

    suspend fun updateProduct(token :String, product_id: String, request:UpdateRequest) : UpdateResponse {
        return RetrofitInstance.api.updateProduct(token,product_id, request)
    }

    suspend fun removeProduct(token:String, product_id:String): RemoveResponse {
        return RetrofitInstance.api.removeProduct(token,product_id)
    }

    suspend fun getOrders(token: String, limit: Int): OrderResponse {
        return RetrofitInstance.api.getOrders(token, limit)
    }

}