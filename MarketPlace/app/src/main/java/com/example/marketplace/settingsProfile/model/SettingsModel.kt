package com.example.marketplace.settingsProfile.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SettingsRequest(
    var username: String?,
    var email: String?,
    var phone_number: String?
)
@JsonClass(generateAdapter = true)
data class UserUpdateResponse(
    var username: String?,
    var phone_number: String?,
    var email: String?,
    var token:String

)
@JsonClass(generateAdapter = true)
data class SettingsResponse(
    var code: Int,
    var updateData: UserUpdateResponse,
    var timestamp:Long
)