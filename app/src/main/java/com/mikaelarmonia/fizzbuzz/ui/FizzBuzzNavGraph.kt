package com.mikaelarmonia.fizzbuzz.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.mikaelarmonia.game.settings.ui.GameSettingsComponent
import com.mikaelarmonia.game.settings.ui.screen.GameSettingsScreen

fun NavGraphBuilder.fizzBuzzNavGraph(navController: NavHostController) {
    composable(
        GameSettingsScreen.baseRoute,
        arguments = GameSettingsScreen.navArgs
    ) {
        GameSettingsComponent(
            onSettingsValidated = {

            }
        )
    }
}
