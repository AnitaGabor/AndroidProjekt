package com.example.marketplace.repository

import com.example.marketplace.api.RetrofitInstance
import com.example.marketplace.models.LoginRequest
import com.example.marketplace.models.LoginResponse
import com.example.marketplace.models.ProductResponse

class Repository {
    suspend fun getPost(token: String): ProductResponse{
        return RetrofitInstance.api.getPost(token)
    }

    suspend fun login(request: LoginRequest): LoginResponse {
        return RetrofitInstance.api.login(request)
    }
}