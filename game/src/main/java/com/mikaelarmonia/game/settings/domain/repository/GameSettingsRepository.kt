package com.mikaelarmonia.game.settings.domain.repository

import com.mikaelarmonia.game.settings.data.model.GameSettings
import kotlinx.coroutines.flow.Flow

interface GameSettingsRepository {
    fun streamGameSettings(): Flow<GameSettings>
    fun updateGameSettings(settings: GameSettings)
}