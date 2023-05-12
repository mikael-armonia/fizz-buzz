package com.mikaelarmonia.forms.ui.model

import androidx.annotation.StringRes

data class FormInputStringField(
    override val inputId: String,
    @StringRes override val titleResId: Int,
    override val value: String? = null,
    @StringRes override val errorMessageResId: Int? = null,
) : FormInputField<String?>()
