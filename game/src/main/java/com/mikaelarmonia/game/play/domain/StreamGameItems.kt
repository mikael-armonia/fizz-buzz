package com.mikaelarmonia.game.play.domain

import com.mikaelarmonia.game.settings.domain.repository.GameSettingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StreamGameItems(
    private val gameSettingsRepository: GameSettingsRepository
) {
    operator fun invoke(): Flow<List<String>> = gameSettingsRepository.streamGameSettings()
        .map { gameSettings ->
            with(gameSettings) {
                (1..threshold).map { i ->
                    when {
                        i.isMultipleOf(number1) && i.isMultipleOf(number2) -> "$word1$word2"
                        i.isMultipleOf(number1) -> word1
                        i.isMultipleOf(number2) -> word2
                        else -> i.toString()
                    }
                }
            }
        }
}

private fun Int.isMultipleOf(otherNumber: Int): Boolean = mod(otherNumber) == 0
