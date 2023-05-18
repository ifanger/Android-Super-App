package com.ifanger.market.usecase.item

import com.ifanger.market.model.MarketItem
import com.ifanger.market.repository.ItemRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

internal class GetMarketItemUseCaseTest {

    private val itemRepository: ItemRepository = mockk(relaxed = true)

    private lateinit var getItemUseCase: GetItemUseCase

    @Before
    fun setUp() {
        getItemUseCase = GetItemUseCase(itemRepository)
    }

    @Test
    fun shouldGetItem() = runTest {
        // Arrange
        val item = mockk<MarketItem>(relaxed = true)
        coEvery { itemRepository.getItem(any()) } returns item

        // Act
        val result = getItemUseCase("1")

        // Assert
        assertEquals(item, result)
    }
}