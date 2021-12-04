package com.example.marketplace.models

data class User(var username: String="", var password: String="", val email: String="", var phone_number: String="")


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
