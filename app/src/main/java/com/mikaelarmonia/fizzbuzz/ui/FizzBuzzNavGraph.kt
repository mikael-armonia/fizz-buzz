package com.mikaelarmonia.fizzbuzz.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.mikaelarmonia.game.play.ui.GamePlayComponent
import com.mikaelarmonia.game.play.ui.screen.GamePlayScreen
import com.mikaelarmonia.game.settings.ui.GameSettingsComponent
import com.mikaelarmonia.game.settings.ui.screen.GameSettingsScreen

fun NavGraphBuilder.fizzBuzzNavGraph(navController: NavHostController) {
    composable(
        GameSettingsScreen.baseRoute,
        arguments = GameSettingsScreen.navArgs
    ) {
        GameSettingsComponent(
            modifier = Modifier.fillMaxWidth(),
            onSettingsValidated = {
                navController.navigate(GamePlayScreen.destination())
            }
        )
    }
    composable(
        GamePlayScreen.baseRoute,
        arguments = GamePlayScreen.navArgs,
    ) {
        GamePlayComponent(modifier = Modifier.fillMaxWidth())
    }
}
