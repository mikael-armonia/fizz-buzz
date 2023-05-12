package com.mikaelarmonia.game.settings.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mikaelarmonia.forms.ui.FormComponent
import org.koin.androidx.compose.koinViewModel

@Composable
fun GameSettingsComponent(
    modifier: Modifier = Modifier,
    viewModel: GameSettingsViewModel = koinViewModel(),
    onSettingsValidated: () -> Unit,
) {
    val state by viewModel.state.collectAsState()

    FormComponent(
        modifier = modifier.padding(8.dp),
        fields = state.formFields,
        onValueChangedListener = viewModel::onValueChanged,
        onValidate = {
            viewModel.onValidate()
            onSettingsValidated()
        },
    )
}