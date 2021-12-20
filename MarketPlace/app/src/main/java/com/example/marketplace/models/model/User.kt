package com.example.marketplace.models.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(var username: String="", var password: String="", var email: String="", var phone_number: String="")












