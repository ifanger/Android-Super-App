package com.ifanger.market.impl.repository.item.adapter

import com.ifanger.market.domain.model.MarketItem
import com.ifanger.market.impl.model.entity.MarketItemEntity

internal class MarketItemEntityAdapter {

    fun toDomain(marketItemEntity: MarketItemEntity): MarketItem {
        return MarketItem(
            id = marketItemEntity.id.toString(),
            name = marketItemEntity.name,
            quantity = marketItemEntity.quantity,
            done = marketItemEntity.done,
        )
    }

    fun toEntity(marketItem: MarketItem): MarketItemEntity {
        return MarketItemEntity(
            id = marketItem.id.toLong(),
            name = marketItem.name,
            quantity = marketItem.quantity,
            done = marketItem.done,
        )
    }
}