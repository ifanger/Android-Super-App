package com.ifanger.market.impl.repository.item

import com.ifanger.market.domain.model.MarketItem
import com.ifanger.market.domain.repository.ItemRepository
import com.ifanger.market.impl.data.room.MarketItemDao
import com.ifanger.market.impl.repository.item.adapter.MarketItemEntityAdapter

internal class ItemRepositoryImpl(
    private val itemsDao: MarketItemDao,
    private val adapter: MarketItemEntityAdapter,
) : ItemRepository {

    override suspend fun getItems(): List<MarketItem> {
        return itemsDao.getAll().map { adapter.toDomain(it) }
    }

    override suspend fun getItem(id: String): MarketItem? {
        return itemsDao.getById(id.toLong())?.let { adapter.toDomain(it) }
    }

    override suspend fun addItem(marketItem: MarketItem) {
        itemsDao.insertAll(adapter.toEntity(marketItem))
    }

    override suspend fun updateItem(marketItem: MarketItem) {
        itemsDao.update(adapter.toEntity(marketItem))
    }

    override suspend fun deleteItem(id: String) {
        itemsDao.delete(id.toLong())
    }
}