package com.example.marketplace.models

data class User(var username: String="", var password: String="", var email: String="", var phone_number: String="")


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

data class ResetRequest(
    var username: String,
    var email: String
)

data class ResetResponse(
    var code: Int,
    var message: String,
    var timestamp:Long
)

data class SettingsRequest(
    var username: String,
    var email: String,
    var phone_number: String
)

data class UserUpdateResponse(
    var username: String,
    var phone_number: String,
    var email: String,
    var token:String

)
data class SettingsResponse(
    var code: Int,
    var updateData: UserUpdateResponse,
    var timestamp:Long
)