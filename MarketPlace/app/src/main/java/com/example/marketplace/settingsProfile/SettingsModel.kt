package com.example.marketplace.settingsProfile

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