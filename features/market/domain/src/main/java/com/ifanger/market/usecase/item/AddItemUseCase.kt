package com.ifanger.market.usecase.item

import com.ifanger.market.model.MarketItem
import com.ifanger.market.repository.ItemRepository
import com.ifanger.market.usecase.item.validator.ItemNameValidator

class AddItemUseCase(
    private val itemRepository: ItemRepository,
    private val itemNameValidator: ItemNameValidator,
) {
    suspend operator fun invoke(item: MarketItem) {
        validate(item)
        itemRepository.addItem(item)
    }

    private fun validate(item: MarketItem) {
        itemNameValidator(item.name)
    }
}