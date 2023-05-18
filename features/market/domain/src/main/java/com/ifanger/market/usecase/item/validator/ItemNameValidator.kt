package com.ifanger.market.usecase.item.validator

import com.ifanger.market.usecase.item.validator.exceptions.InvalidItemNameException

class ItemNameValidator {

    operator fun invoke(name: String) {
        if (name.length < 3) {
            throw InvalidItemNameException()
        }
    }
}