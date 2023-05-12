package com.mikaelarmonia.forms.ui.input

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.mikaelarmonia.fizzbuzz.forms.R
import com.mikaelarmonia.forms.ui.FormScope
import com.mikaelarmonia.forms.ui.model.FormInputNumberField

@Composable
internal fun FormScope.FormInputNumber(
    modifier: Modifier = Modifier,
    title: String,
    entry: FormInputNumberField,
    imeAction: ImeAction = ImeAction.Next,
) {
    var stringValue by remember {
        mutableStateOf(
            entry.value?.toString() ?: ""
        )
    }

    FormInput(
        modifier = modifier,
        inputId = entry.inputId,
        title = title,
        value = stringValue,
        onValueChanged = { inputId, newValue ->
            stringValue = newValue

            onInputValueChanged(
                inputId,
                newValue
            )
        },
        hint = stringResource(id = R.string.form_input_number_hint),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
            imeAction = imeAction
        ),
        errorMessage = entry.errorMessageResId?.let { stringResource(id = it) }
    )
}
