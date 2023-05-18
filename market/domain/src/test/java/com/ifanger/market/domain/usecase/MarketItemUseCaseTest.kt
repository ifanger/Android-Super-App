package com.ifanger.market.domain.usecase

import com.ifanger.market.domain.model.MarketItem
import com.ifanger.market.domain.usecase.item.AddItemUseCase
import com.ifanger.market.domain.usecase.item.DeleteItemUseCase
import com.ifanger.market.domain.usecase.item.GetItemUseCase
import com.ifanger.market.domain.usecase.item.GetItemsUseCase
import com.ifanger.market.domain.usecase.item.UpdateItemUseCase
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

internal class MarketItemUseCaseTest {

    private val getItemsUseCase: GetItemsUseCase = mockk(relaxed = true)
    private val getItemUseCase: GetItemUseCase = mockk(relaxed = true)
    private val addItemUseCase: AddItemUseCase = mockk(relaxed = true)
    private val updateItemUseCase: UpdateItemUseCase = mockk(relaxed = true)
    private val deleteItemUseCase: DeleteItemUseCase = mockk(relaxed = true)

    private lateinit var marketItemUseCase: MarketItemUseCase

    @Before
    fun setUp() {
        marketItemUseCase = MarketItemUseCase(
            getAll = getItemsUseCase,
            getById = getItemUseCase,
            add = addItemUseCase,
            update = updateItemUseCase,
            delete = deleteItemUseCase
        )
    }

    @Test
    fun shouldGetItems() = runTest {
        // Arrange

        // Act
        marketItemUseCase.getAll()

        // Assert
        coVerify { getItemsUseCase() }
    }

    @Test
    fun shouldGetItem() = runTest {
        // Arrange
        val id = "id"

        // Act
        marketItemUseCase.getById(id)

        // Assert
        coVerify { getItemUseCase(id) }
    }

    @Test
    fun shouldAddItem() = runTest {
        // Arrange
        val item = mockk<MarketItem>(relaxed = true)

        // Act
        marketItemUseCase.add(item)

        // Assert
        coVerify { addItemUseCase(item) }
    }

    @Test
    fun shouldUpdateItem() = runTest {
        // Arrange
        val item = mockk<MarketItem>(relaxed = true)

        // Act
        marketItemUseCase.update(item)

        // Assert
        coVerify { updateItemUseCase(item) }
    }

    @Test
    fun shouldDeleteItem() = runTest {
        // Arrange
        val id = "id"

        // Act
        marketItemUseCase.delete(id)

        // Assert
        coVerify { deleteItemUseCase(id) }
    }
}