package com.example.marketplace.profile

import com.example.marketplace.models.model.User

data class UserProfile(
    var username: String,
    var phone_number: String,
    var email: String
)

data class UserResponse(
    var code:Int,
    var data: User,
    val timestamp: Long
)