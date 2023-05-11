package com.mikaelarmonia.forms.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FormComponent(
    modifier: Modifier = Modifier,
    onValueChangedListener: (inputId: String, value: String) -> Unit,
    content: @Composable FormScope.(modifier: Modifier) -> Unit
) {
    val formScope = object : FormScope {
        override fun onInputValueChanged(inputId: String, value: String) {
            onValueChangedListener(inputId, value)
        }
    }

    Column(modifier = modifier) {
        formScope.content(modifier = Modifier)
    }
}
