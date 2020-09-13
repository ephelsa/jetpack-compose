package com.ephelsa.github.composebasics.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val BlueLightColors = lightColors(
    primary = Color(red = 68, green = 157, blue = 209),
    primaryVariant = Color(red = 82, green = 121, blue = 111),
    secondary = Color(red = 68, green = 157, blue = 209),
    secondaryVariant = Color(red = 235, green = 235, blue = 235)
)

val BlueDarkColors = darkColors(
    primary = Color(red = 68, green = 157, blue = 209),
    primaryVariant = Color(red = 58, green = 147, blue = 199),
    secondary = Color(red = 15, green = 15, blue = 15),
)
