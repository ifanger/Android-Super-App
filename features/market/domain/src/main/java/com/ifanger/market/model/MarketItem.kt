package com.ifanger.market.model

data class MarketItem(
    val id: String,
    val name: String,
    val quantity: Int = 0,
    val done: Boolean = false,
)