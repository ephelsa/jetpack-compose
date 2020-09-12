package com.ephelsa.github.composebasics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting(name = "Leonardo")
        }
    }
}

// 1. Composable functions
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name")
}

@Preview
@Composable
fun PreviewGreeting() {
    Greeting("Leonardo")
}

// 2. Layout & 3. Material Design
@Composable
fun NewsStory() {
    val image = imageResource(R.drawable.header)
    MaterialTheme {
        val typography = MaterialTheme.typography
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalGravity = Alignment.Start

        ) {
            val imageModifier = Modifier
                .preferredHeight(180.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(4.dp))

            Image(
                asset = image,
                modifier = imageModifier,
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,
                alpha = 0.9f,
                colorFilter = ColorFilter(Color.Green, BlendMode.Overlay)
            )

            Spacer(modifier = Modifier.preferredHeight(16.dp))

            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                        "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim " +
                        "veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea " +
                        "commodo consequat. Duis aute irure dolor in reprehenderit in voluptate " +
                        "velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint " +
                        "occaecat cupidatat non proident, sunt in culpa qui officia deserunt " +
                        "mollit anim id est laborum.",
                style = typography.h6,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "Sincelejo, Sucre",
                style = typography.body2
            )
            Text(
                text = "September 2020",
                style = typography.body2
            )
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    NewsStory()
}