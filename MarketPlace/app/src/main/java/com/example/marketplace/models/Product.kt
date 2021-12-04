package com.example.marketplace.models

data class Product(val rating: Double,
                   val amount_type: String,
                   val price_type: String,
                   val product_id: String,
                   val username: String,
                   val is_active: Boolean,
                   val price_per_unit: String,
                   val units: String,
                   val description: String,
                   val title: String,
                   //val images: List<Image>,
                   val creation_time: Long)

data class ProductResponse(val item_count: Int, val products: List<Product>, val timestamp: Long)
