package com.mikaelarmonia.forms.domain.validator.error

sealed class NumberValidatorError : ValidatorError() {
    object NotANumberError : NumberValidatorError()
    object NegativeNumberError : NumberValidatorError()
    object TooManyDigitsError : NumberValidatorError()
}
