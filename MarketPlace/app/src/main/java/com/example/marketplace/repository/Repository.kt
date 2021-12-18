package com.example.marketplace.repository

import com.example.marketplace.api.RetrofitInstance
import com.example.marketplace.timeline.*
import com.example.marketplace.login.*
import com.example.marketplace.register.*
import com.example.marketplace.forgetPassword.*
import com.example.marketplace.settingsProfile.*
import com.example.marketplace.profile.*

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
}