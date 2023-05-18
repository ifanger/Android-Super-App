package com.ifanger.market.domain.usecase.item

import com.ifanger.market.domain.repository.ItemRepository
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

internal class DeleteMarketItemUseCaseTest {

    private val itemRepository: ItemRepository = mockk(relaxed = true)

    private lateinit var deleteItemUseCase: DeleteItemUseCase

    @Before
    fun setUp() {
        deleteItemUseCase = DeleteItemUseCase(itemRepository)
    }

    @Test
    fun shouldDeleteItem() = runTest {
        // Arrange
        val itemId = "itemId"

        // Act
        deleteItemUseCase(itemId)

        // Assert
        coVerify(exactly = 1) { itemRepository.deleteItem(itemId) }
    }
}