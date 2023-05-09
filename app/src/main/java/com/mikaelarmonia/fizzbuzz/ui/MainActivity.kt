package com.mikaelarmonia.fizzbuzz.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.mikaelarmoni.ui.theme.FizzBuzzTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FizzBuzzTheme {
                MainComponent()
            }
        }
    }
}

@Composable
fun MainComponent() {

}
