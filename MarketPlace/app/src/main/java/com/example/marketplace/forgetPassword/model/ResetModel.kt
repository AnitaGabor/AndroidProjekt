package com.example.marketplace.forgetPassword.model


data class ResetRequest(
    var username: String,
    var email: String
)

data class ResetResponse(
    var code: Int,
    var message: String,
    var timestamp:Long
)