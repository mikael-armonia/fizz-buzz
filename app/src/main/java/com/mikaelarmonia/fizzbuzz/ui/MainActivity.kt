package com.mikaelarmonia.fizzbuzz.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.mikaelarmonia.game.settings.ui.screen.GameSettingsScreen
import com.mikaelarmonia.ui.theme.FizzBuzzTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FizzBuzzTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = GameSettingsScreen.baseRoute) {
                    fizzBuzzNavGraph(navController)
                }
            }
        }
    }
}
