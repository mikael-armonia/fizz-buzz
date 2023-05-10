package com.mikaelarmonia.forms.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FormComponent(
    modifier: Modifier = Modifier,
    content: @Composable (modifier: Modifier) -> Unit
) {
    Column(modifier = modifier) {
        content(modifier = Modifier)
    }
}
