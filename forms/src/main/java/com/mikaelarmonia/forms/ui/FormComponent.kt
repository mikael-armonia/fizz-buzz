package com.mikaelarmonia.forms.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.mikaelarmonia.fizzbuzz.forms.R
import com.mikaelarmonia.forms.ui.button.FormButton
import com.mikaelarmonia.forms.ui.input.FormInputNumber
import com.mikaelarmonia.forms.ui.input.FormInputString
import com.mikaelarmonia.forms.ui.model.FormInputField
import com.mikaelarmonia.forms.ui.model.FormInputNumberField
import com.mikaelarmonia.forms.ui.model.FormInputStringField

@Composable
fun FormComponent(
    modifier: Modifier = Modifier,
    onValueChangedListener: (inputId: String, value: String) -> Unit,
    onValidate: () -> Unit = {},
    fields: List<FormInputField<*>>,
) {
    val formScope = object : FormScope {
        override fun onInputValueChanged(inputId: String, value: String) {
            onValueChangedListener(inputId, value)
        }
    }
    val scrollState = rememberScrollState()

    Column(modifier = modifier.verticalScroll(scrollState)) {
        fields.forEachIndexed { i, field ->
            val imeAction = if (i == fields.lastIndex) {
                ImeAction.Done
            } else {
                ImeAction.Next
            }
            val title = stringResource(id = field.titleResId)

            when (field) {
                is FormInputNumberField -> {
                    formScope.FormInputNumber(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                        title = title,
                        entry = field,
                        imeAction = imeAction
                    )
                }
                is FormInputStringField -> {
                    formScope.FormInputString(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                        title = title,
                        entry = field,
                        imeAction = imeAction
                    )
                }
            }
        }

        FormButton(
            modifier = Modifier.padding(vertical = 8.dp),
            text = stringResource(id = R.string.form_validate_button_text),
            enabled = fields.all { it.errorMessageResId == null && it.value != null },
            onClick = onValidate,
        )
    }
}
