package com.example.marketplace.repository

import com.example.marketplace.api.RetrofitInstance
import com.example.marketplace.models.*

class Repository {
    suspend fun getProducts(token: String): ProductResponse {
        return RetrofitInstance.api.getProducts(token)
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
}