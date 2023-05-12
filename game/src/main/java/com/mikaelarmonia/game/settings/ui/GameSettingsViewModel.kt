package com.mikaelarmonia.game.settings.ui

import com.mikaelarmonia.fizzbuzz.game.R
import com.mikaelarmonia.forms.ui.model.FormInputField
import com.mikaelarmonia.forms.ui.model.FormInputNumberField
import com.mikaelarmonia.forms.ui.model.FormInputStringField
import com.mikaelarmonia.forms.ui.stringRes
import com.mikaelarmonia.forms.validator.InputNumberValidator
import com.mikaelarmonia.game.settings.data.model.GameSettings
import com.mikaelarmonia.game.settings.domain.UpdateGameSettings
import com.mikaelarmonia.game.settings.ui.GameSettingsViewModel.State
import com.mikaelarmonia.ui.FizzBuzzViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class GameSettingsViewModel(
    private val inputNumberValidator: InputNumberValidator,
    private val updateGameSettings: UpdateGameSettings,
) : FizzBuzzViewModel<State>() {
    override val _state: MutableStateFlow<State> = MutableStateFlow(State())

    init {
        updateViewState { copy(
            formFields = createFormFields()
        ) }
    }

    private fun createFormFields(): List<FormInputField<*>> =
        listOf(
            FormInputNumberField(
                inputId = INPUT_FIELD_NUMBER_1,
                titleResId = R.string.input_field_number_1_title,
            ),
            FormInputNumberField(
                inputId = INPUT_FIELD_NUMBER_2,
                titleResId = R.string.input_field_number_2_title,
            ),
            FormInputStringField(
                inputId = INPUT_FIELD_WORD_1,
                titleResId = R.string.input_field_word_1_title,
            ),
            FormInputStringField(
                inputId = INPUT_FIELD_WORD_2,
                titleResId = R.string.input_field_word_2_title,
            ),
            FormInputNumberField(
                inputId = INPUT_FIELD_THRESHOLD,
                titleResId = R.string.input_field_threshold_title,
            ),
        )

    fun onValueChanged(inputId: String, value: String) {
        updateViewState { copy(
            formFields = when (inputId) {
                INPUT_FIELD_NUMBER_1,
                INPUT_FIELD_NUMBER_2,
                INPUT_FIELD_THRESHOLD -> {
                    val checkResult = inputNumberValidator.checkForErrors(value)
                    formFields.replace<FormInputNumberField>(inputId = inputId) { field ->
                        var newField = field

                        checkResult.onSuccess {
                            newField = field.copy(
                                value = value.toInt(),
                                errorMessageResId = null,
                            )
                        }
                        checkResult.onFailure { error ->
                            newField = field.copy(
                                value = null,
                                errorMessageResId = error.stringRes()
                            )
                        }

                        newField
                    }
                }
                INPUT_FIELD_WORD_1,
                INPUT_FIELD_WORD_2 -> {
                    formFields.replace<FormInputStringField>(inputId = inputId) { field ->
                        field.copy(value = value)
                    }
                }
                else -> { formFields }
            }
        ) }
    }

    fun onValidate() {
        state.value.formFields.run {
            val number1 = first { it.inputId == INPUT_FIELD_NUMBER_1 }.value as Int
            val number2 = first { it.inputId == INPUT_FIELD_NUMBER_2 }.value as Int
            val word1 = first { it.inputId == INPUT_FIELD_WORD_1 }.value as String
            val word2 = first { it.inputId == INPUT_FIELD_WORD_2 }.value as String
            val threshold = first { it.inputId == INPUT_FIELD_THRESHOLD }.value as Int

            updateGameSettings(GameSettings(
                number1 = number1,
                number2 = number2,
                word1 = word1,
                word2 = word2,
                threshold = threshold,
            ))
        }
    }

    data class State(
        val formFields: List<FormInputField<*>> = emptyList()
    )
}

private const val INPUT_FIELD_NUMBER_1 = "number1"
private const val INPUT_FIELD_NUMBER_2 = "number2"
private const val INPUT_FIELD_WORD_1 = "word1"
private const val INPUT_FIELD_WORD_2 = "word2"
private const val INPUT_FIELD_THRESHOLD = "threshold"

private inline fun <reified T : FormInputField<*>> List<FormInputField<*>>.replace(
    inputId: String,
    crossinline action: (T) -> T
) = toMutableList().apply {
    replaceAll { field ->
        if (field.inputId == inputId && field is T) {
            action(field)
        } else {
            field
        }
    }
}
