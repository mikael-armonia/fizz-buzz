package com.mikaelarmonia.game.play.ui.screen

import androidx.navigation.NamedNavArgument
import com.mikaelarmonia.ui.screen.Screen

object GamePlayScreen : Screen() {
    override val baseRoute: String = "game/play"
    override val navArgs: List<NamedNavArgument> = emptyList()
}
