package com.ephelsa.github.composebasics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
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

// 2. Layout
@Composable
fun NewsStory() {
    val image = imageResource(R.drawable.header)

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalGravity = Alignment.CenterHorizontally

    ) {
        val imageModifier = Modifier
            .preferredHeight(180.dp)
            .fillMaxWidth()

        Image(
            asset = image,
            modifier = imageModifier,
            alignment = Alignment.Center,
            contentScale = ContentScale.Fit,
            alpha = 0.9f,
            colorFilter = ColorFilter(Color.Green, BlendMode.Overlay)
        )

        Spacer(modifier = Modifier.preferredHeight(16.dp))

        Text("Jetpack Compose works on Canary AS version")
        Text("Sincelejo, Sucre")
        Text("September 2020")
    }
}

@Preview
@Composable
fun DefaultPreview() {
    NewsStory()
}