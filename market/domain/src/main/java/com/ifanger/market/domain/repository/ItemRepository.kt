package com.ifanger.market.domain.repository

import com.ifanger.market.domain.model.MarketItem

interface ItemRepository {
    suspend fun getItems(): List<MarketItem>
    suspend fun getItem(id: String): MarketItem?
    suspend fun addItem(marketItem: MarketItem)
    suspend fun updateItem(marketItem: MarketItem)
    suspend fun deleteItem(id: String)
}