package com.mikaelarmonia.forms.validator

import com.mikaelarmonia.forms.validator.error.NumberValidatorError
import com.mikaelarmonia.utils.FizzBuzzResult

interface InputFieldValidator {
    fun checkForErrors(value: String): FizzBuzzResult<Unit, NumberValidatorError>
}
