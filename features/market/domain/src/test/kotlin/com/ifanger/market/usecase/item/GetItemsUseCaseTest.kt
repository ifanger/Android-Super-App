package com.ifanger.market.usecase.item

import com.ifanger.market.model.MarketItem
import com.ifanger.market.repository.ItemRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

internal class GetItemsUseCaseTest {

    private val itemRepository: ItemRepository = mockk(relaxed = true)

    private lateinit var getItemsUseCase: GetItemsUseCase

    @Before
    fun setUp() {
        getItemsUseCase = GetItemsUseCase(itemRepository)
    }

    @Test
    fun shouldGetItems() = runTest {
        // Arrange
        val items = mockk<List<MarketItem>>(relaxed = true)
        coEvery { itemRepository.getItems() } returns items

        // Act
        val result = getItemsUseCase()

        // Assert
        coVerify(exactly = 1) { itemRepository.getItems() }
        assertEquals(items, result)
    }
}