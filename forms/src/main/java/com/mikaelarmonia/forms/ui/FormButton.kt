package com.mikaelarmonia.forms.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FormButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit = {}
) {
    Box(Modifier.fillMaxWidth()) {
        Button(
            modifier = modifier.align(Alignment.Center),
            onClick = onClick,
            enabled = enabled,
            contentPadding = PaddingValues(12.dp),
        ) {
            Text(text = text, style = MaterialTheme.typography.h6)
        }
    }
}
