package com.ifanger.market.usecase.item

import com.ifanger.market.model.MarketItem
import com.ifanger.market.repository.ItemRepository

class UpdateItemUseCase(
    private val itemRepository: ItemRepository,
) {
    suspend operator fun invoke(marketItem: MarketItem) {
        itemRepository.updateItem(marketItem)
    }
}