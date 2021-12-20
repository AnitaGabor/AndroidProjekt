package com.example.marketplace.profile.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserProfile(
    var username: String,
    var phone_number: String,
    var email: String
)

@JsonClass(generateAdapter = true)
data class UserResponse(
    var code:Int,
    var data: List<UserProfile>,
    val timestamp: Long
)