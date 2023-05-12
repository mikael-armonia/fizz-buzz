package com.mikaelarmonia.game.play.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mikaelarmonia.game.play.ui.item.GamePlayItem
import org.koin.androidx.compose.koinViewModel

@Composable
fun GamePlayComponent(
    modifier: Modifier = Modifier,
    viewModel: GamePlayViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()

    LazyColumn(modifier = modifier) {
        items(count = state.fizzBuzzItems.size) { i ->
            GamePlayItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                item = state.fizzBuzzItems[i]
            )

            if (i < state.fizzBuzzItems.lastIndex) {
                Divider()
            }
        }
    }
}
