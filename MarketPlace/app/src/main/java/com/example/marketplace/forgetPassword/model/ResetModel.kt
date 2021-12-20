package com.example.marketplace.forgetPassword.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResetRequest(
    var username: String,
    var email: String
)

@JsonClass(generateAdapter = true)
data class ResetResponse(
    var code: Int,
    var message: String,
    var timestamp:Long
)