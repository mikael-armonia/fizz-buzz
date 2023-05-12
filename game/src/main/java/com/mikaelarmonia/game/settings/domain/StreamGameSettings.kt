package com.mikaelarmonia.game.settings.domain

import com.mikaelarmonia.game.settings.data.model.GameSettings
import com.mikaelarmonia.game.settings.domain.repository.GameSettingsRepository
import kotlinx.coroutines.flow.Flow

class StreamGameSettings(
    private val gameSettingsRepository: GameSettingsRepository
) {
    operator fun invoke(): Flow<GameSettings> = gameSettingsRepository.streamGameSettings()
}