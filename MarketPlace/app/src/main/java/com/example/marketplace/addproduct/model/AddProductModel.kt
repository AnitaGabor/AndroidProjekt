package com.example.marketplace.addproduct.model

import com.example.marketplace.timeline.model.Product
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AddProductResponse(
    val creation:String,
    val productData:Product
)