package com.mikaelarmonia.game.settings.di

import com.mikaelarmonia.forms.validator.InputNumberValidator
import com.mikaelarmonia.game.settings.data.repository.GameSettingsRepositoryImpl
import com.mikaelarmonia.game.settings.domain.UpdateGameSettings
import com.mikaelarmonia.game.settings.domain.repository.GameSettingsRepository
import com.mikaelarmonia.game.settings.ui.GameSettingsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val gameSettingsModule = module {
    single<GameSettingsRepository> { GameSettingsRepositoryImpl() }

    factory { UpdateGameSettings(gameSettingsRepository = get()) }

    factory { InputNumberValidator(maxDigits = 3) }

    viewModel {
        GameSettingsViewModel(
            inputNumberValidator = get(),
            updateGameSettings = get(),
        )
    }
}
