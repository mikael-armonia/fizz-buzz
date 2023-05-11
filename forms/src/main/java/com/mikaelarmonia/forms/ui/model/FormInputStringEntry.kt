package com.mikaelarmonia.forms.ui.model

import androidx.annotation.StringRes

data class FormInputStringEntry(
    override val value: String,
    @StringRes override val errorMessageId: Int? = null,
) : FormInputEntry<String>()
