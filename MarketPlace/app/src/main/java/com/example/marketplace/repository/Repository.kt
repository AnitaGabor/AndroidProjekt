package com.example.marketplace.repository

import com.example.marketplace.addproduct.model.*
import com.example.marketplace.api.RetrofitInstance
import com.example.marketplace.timeline.model.*
import com.example.marketplace.login.model.*
import com.example.marketplace.register.model.*
import com.example.marketplace.forgetPassword.model.*
import com.example.marketplace.settingsProfile.model.*
import com.example.marketplace.profile.model.*

class Repository {
    suspend fun getProducts(token: String, limit:Int): ProductResponse {
        return RetrofitInstance.api.getProducts(token, limit)
    }

    suspend fun login(request: LoginRequest): LoginResponse {
        return RetrofitInstance.api.login(request)
    }

    suspend fun register(request: RegisterRequest) : RegisterResponse{
        return RetrofitInstance.api.register(request)
    }

    suspend fun  reset(request: ResetRequest) : ResetResponse{
        return RetrofitInstance.api.reset(request)
    }

    suspend fun updateUser(token:String, request: SettingsRequest) : SettingsResponse{
        return RetrofitInstance.api.updateUser(token,request)
    }

    suspend fun  getUserData(username:String) : UserResponse{
        return RetrofitInstance.api.getUserData(username)
    }

    suspend fun addProduct(token:String,request:AddProductRequest): AddProductResponse{
        return RetrofitInstance.api.addProduct(token, request)
    }
}