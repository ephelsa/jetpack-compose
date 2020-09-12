package com.ephelsa.github.composebasics.model

import androidx.compose.ui.graphics.ImageAsset

data class Artist(
    val imageResource: Int,
    val name: String,
    val gender: String,
    val phrase: String
)
