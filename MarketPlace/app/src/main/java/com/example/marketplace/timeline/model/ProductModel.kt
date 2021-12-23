package com.example.marketplace.timeline.model

data class Product(val rating: Double = 0.0,
                   val amount_type: String ="",
                   val price_type: String ="",
                   var product_id: String="",
                   val username: String="",
                   var is_active: Boolean =false,
                   var price_per_unit: String ="",
                   var units: String ="",
                   var description: String ="",
                   var title: String ="",
                   val creation_time: Long =0
)


data class ProductResponse(val item_count: Int, val products: List<Product>, val timestamp: Long)


