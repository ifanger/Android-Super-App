package com.ifanger.market.usecase.item

import com.ifanger.market.model.MarketItem
import com.ifanger.market.repository.ItemRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

internal class UpdateMarketItemUseCaseTest {

    private val itemRepository: ItemRepository = mockk(relaxed = true)

    private lateinit var updateItemUseCase: UpdateItemUseCase

    @Before
    fun setUp() {
        updateItemUseCase = UpdateItemUseCase(itemRepository)
    }

    @Test
    fun shouldUpdateItem() = runTest {
        // Arrange
        val item = mockk<MarketItem>(relaxed = true)

        // Act
        updateItemUseCase(item)

        // Assert
        coVerify(exactly = 1) { itemRepository.updateItem(item) }
    }
}