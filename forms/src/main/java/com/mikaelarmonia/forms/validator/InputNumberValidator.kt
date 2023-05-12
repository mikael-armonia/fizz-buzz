package com.mikaelarmonia.forms.validator

import com.mikaelarmonia.forms.validator.error.NumberValidatorError
import com.mikaelarmonia.utils.FizzBuzzResult
import com.mikaelarmonia.utils.isNumeric

class InputNumberValidator(
    private val maxDigits: Int
) : InputFieldValidator {
    override fun checkForErrors(value: String): FizzBuzzResult<Unit, NumberValidatorError> {
        return when {
            !value.isNumeric() -> FizzBuzzResult.Failure(NumberValidatorError.NotANumberError)
            value.toInt() < 0 -> FizzBuzzResult.Failure(NumberValidatorError.NegativeNumberError)
            value.length > maxDigits -> FizzBuzzResult.Failure(NumberValidatorError.TooManyDigitsError)
            else -> FizzBuzzResult.Success(Unit)
        }
    }
}
