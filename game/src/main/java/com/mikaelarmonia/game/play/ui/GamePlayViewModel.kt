package com.mikaelarmonia.game.play.ui

import androidx.lifecycle.viewModelScope
import com.mikaelarmonia.game.play.domain.StreamGameItems
import com.mikaelarmonia.game.play.ui.GamePlayViewModel.State
import com.mikaelarmonia.ui.FizzBuzzViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class GamePlayViewModel(
    streamGameItems: StreamGameItems
) : FizzBuzzViewModel<State>() {
    override val _state: MutableStateFlow<State> = MutableStateFlow(State())

    init {
        viewModelScope.launch {
            streamGameItems().collect {
                updateViewState { copy(fizzBuzzItems = it) }
            }
        }
    }

    data class State(
        val fizzBuzzItems: List<String> = emptyList()
    )
}