package com.ifanger.market.usecase.item

import com.ifanger.market.repository.ItemRepository

class GetItemUseCase(
    private val itemRepository: ItemRepository
) {
    suspend operator fun invoke(id: String) = itemRepository.getItem(id)
}