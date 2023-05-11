package com.mikaelarmonia.forms.domain.validator

import com.mikaelarmonia.forms.domain.validator.error.NumberValidatorError
import com.mikaelarmonia.utils.FizzBuzzResult
import com.mikaelarmonia.utils.isNumeric

class NumberEntryValidator(
    private val maxDigits: Int
) : EntryValidator {
    override fun checkForErrors(value: String): FizzBuzzResult<Unit, NumberValidatorError> {
        return when {
            !value.isNumeric() -> FizzBuzzResult.Failure(NumberValidatorError.NotANumberError)
            value.toInt() < 0 -> FizzBuzzResult.Failure(NumberValidatorError.NegativeNumberError)
            value.length > maxDigits -> FizzBuzzResult.Failure(NumberValidatorError.TooManyDigitsError)
            else -> FizzBuzzResult.Success(Unit)
        }
    }
}
