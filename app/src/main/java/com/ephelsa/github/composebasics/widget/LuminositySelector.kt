package com.ephelsa.github.composebasics.widget

import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRowFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun LuminosityItem(
    name: String,
    isDark: Boolean,
    onClick: (Boolean) -> Unit
) {
    Text(
        text = name,
        modifier = Modifier.padding(4.dp)
            .clickable(onClick = { onClick(isDark) }),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun LuminositySelector(onSelected: (Boolean) -> Unit) {
    val items = listOf(Pair("Day", false), Pair("Night", true))
    LazyRowFor(items = items) {
        LuminosityItem(name = it.first, isDark = it.second, onClick = onSelected)
    }
}
