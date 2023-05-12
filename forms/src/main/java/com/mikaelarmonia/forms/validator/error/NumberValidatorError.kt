package com.mikaelarmonia.forms.validator.error

sealed class NumberValidatorError : ValidatorError() {
    object NotANumberError : NumberValidatorError()
    object NegativeNumberError : NumberValidatorError()
    object TooManyDigitsError : NumberValidatorError()
}
