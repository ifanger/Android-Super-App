package com.ifanger.market.usecase.item

import com.ifanger.market.repository.ItemRepository

class DeleteItemUseCase(
    private val itemRepository: ItemRepository,
) {
    suspend operator fun invoke(itemId: String) {
        itemRepository.deleteItem(itemId)
    }
}