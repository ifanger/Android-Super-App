package com.ifanger.market.domain.model

data class MarketItem(
    val id: String,
    val name: String,
    val quantity: Int = 0,
    val done: Boolean = false,
)