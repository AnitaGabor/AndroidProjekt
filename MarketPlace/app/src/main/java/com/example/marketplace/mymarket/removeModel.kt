package com.example.marketplace.mymarket

data class RemoveResponse(
    var message:String,
    var product_id:String,
    var deletion_time:Long
)