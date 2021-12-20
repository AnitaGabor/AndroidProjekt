package com.example.marketplace.register.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RegisterRequest(
    var username: String,
    var email: String,
    var password:String
)

@JsonClass(generateAdapter = true)
data class RegisterResponse(
    var code: Int,
    var message: String,
    var creation_time:Long
)