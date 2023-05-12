package com.mikaelarmonia.forms.ui.model

import androidx.annotation.StringRes

data class FormInputNumberField(
    override val inputId: String,
    @StringRes override val titleResId: Int,
    override val value: Int? = null,
    @StringRes override val errorMessageResId: Int? = null,
) : FormInputField<Int?>()
