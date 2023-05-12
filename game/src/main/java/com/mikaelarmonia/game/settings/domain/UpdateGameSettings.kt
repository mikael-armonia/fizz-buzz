package com.mikaelarmonia.game.settings.domain

import com.mikaelarmonia.game.settings.data.model.GameSettings
import com.mikaelarmonia.game.settings.domain.repository.GameSettingsRepository

class UpdateGameSettings(
    private val gameSettingsRepository: GameSettingsRepository
) {
    operator fun invoke(settings: GameSettings) =
        gameSettingsRepository.updateGameSettings(settings)
}