package com.ifanger.market.usecase

import com.ifanger.market.usecase.item.AddItemUseCase
import com.ifanger.market.usecase.item.DeleteItemUseCase
import com.ifanger.market.usecase.item.GetItemUseCase
import com.ifanger.market.usecase.item.GetItemsUseCase
import com.ifanger.market.usecase.item.UpdateItemUseCase

data class MarketItemUseCase(
    val getAll: GetItemsUseCase,
    val getById: GetItemUseCase,
    val add: AddItemUseCase,
    val update: UpdateItemUseCase,
    val delete: DeleteItemUseCase,
)