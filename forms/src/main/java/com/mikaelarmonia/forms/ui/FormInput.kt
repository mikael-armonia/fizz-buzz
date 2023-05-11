package com.mikaelarmonia.forms.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun FormInput(
    modifier: Modifier = Modifier,
    inputId: String,
    title: String,
    value: String = "",
    hint: String = "",
    errorMessage: String? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onValueChanged: (inputId: String, value: String) -> Unit
) {
    val isError: Boolean = errorMessage != null

    Column(modifier = modifier) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = title,
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.padding(4.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = { newValue ->
                onValueChanged(inputId, newValue)
            },
            textStyle = MaterialTheme.typography.body1,
            placeholder = {
                Text(
                    text = hint,
                    style = MaterialTheme.typography.body1
                )
            },
            keyboardOptions = keyboardOptions,
            isError = isError,
        )
        Text(
            text = errorMessage ?: "",
            style = MaterialTheme.typography.caption.copy(color = MaterialTheme.colors.error)
        )
    }
}
