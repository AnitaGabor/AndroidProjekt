package com.example.marketplace.addproduct.model

import com.example.marketplace.timeline.model.Product

data class AddProductRequest(
    val title: String ,
    val price_per_unit: String,
    val units: String,
    val description: String,
    val username:String,
    val email:String,
    val phone_number:String
)

data class AddProductResponse(
    val creation:String,
    val productData:Product
)