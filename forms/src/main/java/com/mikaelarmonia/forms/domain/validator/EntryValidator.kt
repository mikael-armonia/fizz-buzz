package com.mikaelarmonia.forms.domain.validator

import com.mikaelarmonia.forms.domain.validator.error.NumberValidatorError
import com.mikaelarmonia.utils.FizzBuzzResult

interface EntryValidator {
    fun checkForErrors(value: String): FizzBuzzResult<Unit, NumberValidatorError>
}
