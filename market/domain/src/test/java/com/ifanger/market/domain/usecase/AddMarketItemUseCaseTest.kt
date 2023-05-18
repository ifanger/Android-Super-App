package com.ifanger.market.domain.usecase

import com.ifanger.market.domain.model.MarketItem
import com.ifanger.market.domain.repository.ItemRepository
import com.ifanger.market.domain.usecase.item.AddItemUseCase
import com.ifanger.market.domain.usecase.item.validator.ItemNameValidator
import com.ifanger.market.domain.usecase.item.validator.exceptions.InvalidItemNameException
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

internal class AddMarketItemUseCaseTest {

    private val itemRepository: ItemRepository = mockk(relaxed = true)
    private val itemNameValidator: ItemNameValidator = mockk(relaxed = true)

    private lateinit var addItemUseCase: AddItemUseCase

    @Before
    fun setUp() {
        addItemUseCase = AddItemUseCase(itemRepository, itemNameValidator)
    }

    @Test
    fun shouldAddItem() = runTest {
        // Arrange
        every { itemNameValidator(any()) } returns Unit
        val item = mockk<MarketItem>(relaxed = true)

        // Act
        addItemUseCase(item)

        // Assert
        coVerify(exactly = 1) { itemRepository.addItem(item) }
    }

    @Test
    fun shouldValidateItemName() = runTest {
        // Arrange
        every { itemNameValidator(any()) } returns Unit
        val item = mockk<MarketItem>(relaxed = true)

        // Act
        addItemUseCase(item)

        // Assert
        verify(exactly = 1) { itemNameValidator(item.name) }
    }

    @Test(expected = InvalidItemNameException::class)
    fun shouldThrowInvalidItemNameException() = runTest {
        // Arrange
        every { itemNameValidator(any()) } throws InvalidItemNameException()
        val item = mockk<MarketItem>(relaxed = true)

        // Act
        addItemUseCase(item)

        // Assert
        verify(exactly = 1) { itemNameValidator(item.name) }
    }
}