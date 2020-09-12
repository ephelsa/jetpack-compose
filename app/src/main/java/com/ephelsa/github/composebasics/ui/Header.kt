package com.ephelsa.github.composebasics.ui

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import java.util.*

@Composable
fun Header(
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp, top = 14.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = title.toUpperCase(Locale.getDefault()),
            fontSize = TextUnit.Companion.Sp(32),
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview
@Composable
fun PreviewHeader() {
    Header(title = "Artist List")
}
