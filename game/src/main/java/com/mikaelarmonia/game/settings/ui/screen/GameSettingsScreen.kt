package com.mikaelarmonia.game.settings.ui.screen

import androidx.navigation.NamedNavArgument
import com.mikaelarmonia.ui.screen.Screen

object GameSettingsScreen : Screen() {
    override val baseRoute: String = "game/settings"
    override val navArgs: List<NamedNavArgument> = emptyList()
}
