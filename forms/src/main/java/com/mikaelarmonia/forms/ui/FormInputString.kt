package com.mikaelarmonia.forms.ui

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.mikaelarmonia.fizzbuzz.forms.R
import com.mikaelarmonia.forms.ui.model.FormInputStringEntry

@Composable
fun FormScope.FormInputString(
    modifier: Modifier = Modifier,
    inputId: String,
    title: String,
    entry: FormInputStringEntry,
    imeAction: ImeAction = ImeAction.Next,
) {
    FormInput(
        modifier = modifier,
        inputId = inputId,
        title = title,
        value = entry.value,
        onValueChanged = { inputId, newValue ->
            onInputValueChanged(
                inputId,
                newValue
            )
        },
        hint = stringResource(id = R.string.form_input_string_hint),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = imeAction
        ),
        errorMessage = entry.errorMessageId?.let { stringResource(id = it) }
    )
}
