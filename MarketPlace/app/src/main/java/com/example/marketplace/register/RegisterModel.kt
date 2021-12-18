package com.example.marketplace.register

data class RegisterRequest(
    var username: String,
    var email: String,
    var password:String
)

data class RegisterResponse(
    var code: Int,
    var message: String,
    var creation_time:Long
)