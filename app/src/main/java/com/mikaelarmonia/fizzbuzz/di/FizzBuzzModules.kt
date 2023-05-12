package com.mikaelarmonia.fizzbuzz.di

import com.mikaelarmonia.game.play.di.gamePlayModule
import com.mikaelarmonia.game.settings.di.gameSettingsModule

val fizzBuzzModules = listOf(
    gameSettingsModule,
    gamePlayModule,
)