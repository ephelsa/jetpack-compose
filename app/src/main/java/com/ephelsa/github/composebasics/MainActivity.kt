package com.ephelsa.github.composebasics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.ephelsa.github.composebasics.theme.*
import com.ephelsa.github.composebasics.widget.ColorSelector
import com.ephelsa.github.composebasics.widget.ColorTheme
import com.ephelsa.github.composebasics.widget.LuminositySelector


class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    private val colorThemes = listOf(
        ColorTheme(GreenLightColors, GreenDarkColors, "Green"),
        ColorTheme(BlueLightColors, BlueDarkColors, "Blue"),
        ColorTheme(RedLightColor, RedDarkColor, "Red")
    )

    var currentColorTheme by mutableStateOf(GreenLightColors)
    var currentlyIsDark by mutableStateOf(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(
                colors = currentColorTheme
            ) {
                AppContent(
                    colorThemes = colorThemes,
                    isDark = currentlyIsDark,
                    onColorSelected = { currentColorTheme = it },
                    onLuminositySelected = { currentlyIsDark = it }
                )
            }
        }
    }
}

@Composable
fun ThemeBar(
    colorThemes: List<ColorTheme>,
    isDark: Boolean,
    onColorSelected: (Colors) -> Unit,
    onLuminositySelected: (Boolean) -> Unit
) {
    TopAppBar(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalGravity = Alignment.CenterVertically
        ) {
            Column {
                ColorSelector(
                    colorThemes = colorThemes,
                    onSelected = onColorSelected,
                    darkTheme = isDark
                )
            }

            Column {
                LuminositySelector {
                    onLuminositySelected(it)
                }
            }
        }
    }
}


@Composable
fun AppContent(
    colorThemes: List<ColorTheme>,
    onColorSelected: (Colors) -> Unit,
    isDark: Boolean,
    onLuminositySelected: (Boolean) -> Unit
) {
    Scaffold(
        topBar = { ThemeBar(colorThemes, isDark, onColorSelected, onLuminositySelected) },
        bottomBar = {
            Button(onClick = { }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Super Button")
            }
        }
    ) {
        Column(
            modifier = Modifier.padding(top = 12.dp, start = 8.dp, end = 8.dp)
        ) {
            Image(asset = imageResource(id = R.drawable.mercury))
            Text(text = "Freddie Mercury")
        }
    }
}