package com.mikaelarmonia.game.settings.data.repository

import com.mikaelarmonia.game.settings.data.model.GameSettings
import com.mikaelarmonia.game.settings.domain.repository.GameSettingsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class GameSettingsRepositoryImpl(
    override val coroutineContext: CoroutineContext = Dispatchers.Main
) : GameSettingsRepository, CoroutineScope {
    private val gameSettingsStream = MutableStateFlow(GameSettings())

    override fun streamGameSettings(): Flow<GameSettings> = gameSettingsStream

    override fun updateGameSettings(settings: GameSettings) {
        launch {
            gameSettingsStream.emit(settings)
        }
    }
}