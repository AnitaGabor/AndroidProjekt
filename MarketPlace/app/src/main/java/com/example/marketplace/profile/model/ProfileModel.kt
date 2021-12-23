package com.example.marketplace.profile.model

import com.example.marketplace.models.model.User

data class UserResponse(
    var code:Int,
    var data: List<User>,
    val timestamp: Long
)