package com.mikaelarmonia.game.play.ui.item

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun GamePlayItem(
    modifier: Modifier = Modifier,
    item: String
) {
    Text(
        modifier = modifier,
        text = item,
        style = MaterialTheme.typography.h6
    )
}