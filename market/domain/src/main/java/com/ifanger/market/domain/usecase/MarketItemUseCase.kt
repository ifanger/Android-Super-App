package com.ifanger.market.domain.usecase

import com.ifanger.market.domain.usecase.item.AddItemUseCase
import com.ifanger.market.domain.usecase.item.DeleteItemUseCase
import com.ifanger.market.domain.usecase.item.GetItemUseCase
import com.ifanger.market.domain.usecase.item.GetItemsUseCase
import com.ifanger.market.domain.usecase.item.UpdateItemUseCase

data class MarketItemUseCase(
    val getAll: GetItemsUseCase,
    val getById: GetItemUseCase,
    val add: AddItemUseCase,
    val update: UpdateItemUseCase,
    val delete: DeleteItemUseCase,
)