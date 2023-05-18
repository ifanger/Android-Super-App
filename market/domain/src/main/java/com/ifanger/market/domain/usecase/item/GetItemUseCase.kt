package com.ifanger.market.domain.usecase.item

import com.ifanger.market.domain.repository.ItemRepository

class GetItemUseCase(
    private val itemRepository: ItemRepository
) {
    suspend operator fun invoke(id: String) = itemRepository.getItem(id)
}