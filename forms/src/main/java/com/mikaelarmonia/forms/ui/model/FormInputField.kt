package com.mikaelarmonia.forms.ui.model

sealed class FormInputField<T : Any?> : FormField() {
    abstract val value: T
    abstract val inputId: String
    abstract val errorMessageResId: Int?
}
