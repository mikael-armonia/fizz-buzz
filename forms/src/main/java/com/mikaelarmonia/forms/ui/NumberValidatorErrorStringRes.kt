package com.mikaelarmonia.forms.ui

import androidx.annotation.StringRes
import com.mikaelarmonia.fizzbuzz.forms.R
import com.mikaelarmonia.forms.validator.error.NumberValidatorError

@StringRes
fun NumberValidatorError.stringRes(): Int = when (this) {
    NumberValidatorError.NegativeNumberError -> R.string.form_input_number_error_negative_number
    NumberValidatorError.NotANumberError -> R.string.form_input_number_error_nan
    NumberValidatorError.TooManyDigitsError -> R.string.form_input_number_error_too_many_digits
}
