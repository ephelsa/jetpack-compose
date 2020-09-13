package com.ephelsa.github.composebasics.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRowFor
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Colors
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

data class ColorTheme(
    val lightColor: Colors,
    val darkColor: Colors,
    val name: String
)

@Composable
fun ColorSelector(
    colorThemes: List<ColorTheme>,
    darkTheme: Boolean = isSystemInDarkTheme(),
    onSelected: (Colors) -> Unit
) {
    LazyRowFor(
        items = colorThemes
    ) { color ->
        ColorPicker(
            colorTheme = color,
            darkTheme = darkTheme,
            onClick = onSelected
        )
    }
}


@Composable
fun ColorPicker(
    colorTheme: ColorTheme,
    darkTheme: Boolean = isSystemInDarkTheme(),
    onClick: (Colors) -> Unit
) {
    val borderColor = if (darkTheme) Color.White else Color.Black
    val color = if (darkTheme) colorTheme.darkColor else colorTheme.lightColor
    val shapeSize = 40

    Card(
        shape = CircleShape,
        modifier = Modifier.size(shapeSize.dp)
            .padding(2.dp),
        elevation = 4.dp,
        border = BorderStroke(2.dp, borderColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .clickable(
                    onClick = { onClick(color) }
                )
        ) {
            Surface(
                shape = RectangleShape,
                modifier = Modifier
                    .size(
                        width = (shapeSize / 2).dp,
                        height = shapeSize.dp
                    ),
                color = color.primary,
            ) { }

            Surface(
                shape = RectangleShape,
                modifier = Modifier
                    .size(
                        width = (shapeSize / 2).dp,
                        height = shapeSize.dp
                    ),
                color = color.secondary
            ) { }
        }
    }
}
