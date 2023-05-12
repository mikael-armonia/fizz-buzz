package com.mikaelarmonia.game.play.di

import com.mikaelarmonia.game.play.domain.StreamGameItems
import com.mikaelarmonia.game.play.ui.GamePlayViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val gamePlayModule = module {
    factory { StreamGameItems(gameSettingsRepository = get()) }

    viewModel {
        GamePlayViewModel(
            streamGameItems = get()
        )
    }
}