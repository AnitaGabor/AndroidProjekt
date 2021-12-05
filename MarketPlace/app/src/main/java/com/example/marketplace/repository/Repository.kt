package com.example.marketplace.repository

import com.example.marketplace.api.RetrofitInstance
import com.example.marketplace.models.*

class Repository {
    suspend fun getPost(token: String): ProductResponse{
        return RetrofitInstance.api.getPost(token)
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

    suspend fun updateUser(request: SettingsRequest) : SettingsResponse{
        return RetrofitInstance.api.updateUser(request)
    }
}