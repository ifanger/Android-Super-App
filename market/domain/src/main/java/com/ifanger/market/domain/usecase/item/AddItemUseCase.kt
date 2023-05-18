package com.ifanger.market.domain.usecase.item

import com.ifanger.market.domain.model.MarketItem
import com.ifanger.market.domain.repository.ItemRepository
import com.ifanger.market.domain.usecase.item.validator.ItemNameValidator

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