package com.example.marketplace.login

data class LoginRequest (
    var username: String,
    var password: String
)

data class LoginResponse (
    var username: String,
    var email: String,
    var phone_number: String,
    var token: String,
    var creation_time: Long,
    var refresh_time: Long
)