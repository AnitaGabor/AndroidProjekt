package com.example.marketplace.addproduct.model

import com.example.marketplace.timeline.model.Product


data class AddProductResponse(
    val creation:String,
    val productData:Product
)