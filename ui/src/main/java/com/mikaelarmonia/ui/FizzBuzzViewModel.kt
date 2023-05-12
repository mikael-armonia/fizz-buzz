package com.mikaelarmonia.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class FizzBuzzViewModel<S> : ViewModel() {
    protected abstract val _state: MutableStateFlow<S>
    val state: StateFlow<S>
        get() = _state.asStateFlow()

    fun updateViewState(stateUpdater: S.() -> S) {
        _state.value = _state.value.stateUpdater()
    }
}