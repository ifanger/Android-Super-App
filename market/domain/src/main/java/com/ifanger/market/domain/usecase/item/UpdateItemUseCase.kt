package com.ifanger.market.domain.usecase.item

import com.ifanger.market.domain.model.MarketItem
import com.ifanger.market.domain.repository.ItemRepository

class UpdateItemUseCase(
    private val itemRepository: ItemRepository,
) {
    suspend operator fun invoke(marketItem: MarketItem) {
        itemRepository.updateItem(marketItem)
    }
}