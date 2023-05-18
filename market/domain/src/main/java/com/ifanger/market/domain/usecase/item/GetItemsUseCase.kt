package com.ifanger.market.domain.usecase.item

import com.ifanger.market.domain.repository.ItemRepository

class GetItemsUseCase(
    private val itemRepository: ItemRepository
) {
    suspend operator fun invoke() = itemRepository.getItems()
}