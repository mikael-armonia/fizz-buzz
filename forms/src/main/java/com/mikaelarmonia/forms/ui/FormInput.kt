package com.mikaelarmonia.forms.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FormInput(
    modifier: Modifier = Modifier,
    title: String,
    value: String = "",
    hint: String,
    errorMessage: String? = null,
    onValueChanged: (value: String) -> Unit
) {
    val isError: Boolean = errorMessage != null

    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.h5
        )
        Spacer(modifier = Modifier.padding(4.dp))
        TextField(
            value = value,
            onValueChange = onValueChanged,
            textStyle = MaterialTheme.typography.body1,
            placeholder = {
                Text(
                    text = hint,
                    style = MaterialTheme.typography.body1
                )
            },
            isError = isError,
        )
        Text(
            text = errorMessage ?: "",
            style = MaterialTheme.typography.caption.copy(color = MaterialTheme.colors.error)
        )
    }
}
