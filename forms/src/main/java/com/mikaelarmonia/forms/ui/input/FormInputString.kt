package com.mikaelarmonia.forms.ui.input

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.mikaelarmonia.fizzbuzz.forms.R
import com.mikaelarmonia.forms.ui.FormScope
import com.mikaelarmonia.forms.ui.model.FormInputStringField

@Composable
internal fun FormScope.FormInputString(
    modifier: Modifier = Modifier,
    title: String,
    entry: FormInputStringField,
    imeAction: ImeAction = ImeAction.Next,
) {
    FormInput(
        modifier = modifier,
        inputId = entry.inputId,
        title = title,
        value = entry.value ?: "",
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
        errorMessage = entry.errorMessageResId?.let { stringResource(id = it) }
    )
}
