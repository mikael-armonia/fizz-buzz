package com.mikaelarmonia.forms.ui.model

sealed class FormInputEntry<T : Any> {
    abstract val value: T?
    abstract val errorMessageId: Int?
}
