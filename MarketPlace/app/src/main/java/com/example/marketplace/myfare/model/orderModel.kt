package com.example.marketplace.myfare.model

data class Order(var order_id: String="",
                   val username: String="",
                   var status: String="",
                    val owner_username:String="",
                   var price_per_unit: String ="",
                   var units: String ="",
                   var description: String ="",
                   var title: String ="",
                   val creation_time: Long =0
)


data class OrderResponse(val item_count: Int, val orders: List<Order>, val timestamp: Long)

