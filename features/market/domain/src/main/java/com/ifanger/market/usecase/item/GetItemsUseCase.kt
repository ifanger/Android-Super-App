package com.ifanger.market.usecase.item

import com.ifanger.market.repository.ItemRepository

class GetItemsUseCase(
    private val itemRepository: ItemRepository
) {
    suspend operator fun invoke() = itemRepository.getItems()
}