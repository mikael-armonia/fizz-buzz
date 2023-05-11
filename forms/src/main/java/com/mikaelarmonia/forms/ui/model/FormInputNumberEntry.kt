package com.mikaelarmonia.forms.ui.model

import androidx.annotation.StringRes

data class FormInputNumberEntry(
    override val value: Int? = null,
    @StringRes override val errorMessageId: Int? = null,
) : FormInputEntry<Int>()
