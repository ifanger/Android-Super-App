package com.ifanger.market.usecase.item.validator

import com.ifanger.market.usecase.item.validator.exceptions.InvalidItemNameException
import org.junit.Before
import org.junit.Test

internal class ItemNameValidatorTest {


    private lateinit var itemNameValidator: ItemNameValidator

    @Before
    fun setUp() {
        itemNameValidator = ItemNameValidator()
    }

    @Test
    fun shouldValidateItemName() {
        // Arrange
        val name = "name"

        // Act
        itemNameValidator(name)
    }

    @Test(expected = InvalidItemNameException::class)
    fun shouldThrowInvalidItemNameException() {
        // Arrange
        val name = "na"

        // Act
        itemNameValidator(name)
    }
}