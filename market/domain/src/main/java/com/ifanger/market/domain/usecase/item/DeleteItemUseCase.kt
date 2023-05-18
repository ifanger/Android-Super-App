package com.ifanger.market.domain.usecase.item

import com.ifanger.market.domain.repository.ItemRepository

class DeleteItemUseCase(
    private val itemRepository: ItemRepository,
) {
    suspend operator fun invoke(itemId: String) {
        itemRepository.deleteItem(itemId)
    }
}