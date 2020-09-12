package com.ephelsa.github.composebasics.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.ephelsa.github.composebasics.R
import com.ephelsa.github.composebasics.model.Artist


private const val TAG = "ArtistCardPreview"

@Composable
fun ArtistCard(
    artist: Artist,
    onClick: (Artist) -> Unit
) {
    MaterialTheme {
        Card(
            elevation = 4.dp,
            shape = RoundedCornerShape(2.dp),
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { onClick(artist) })
        ) {
            Row(
                verticalGravity = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Image(
                    asset = imageResource(id = artist.imageResource),
                    modifier = Modifier
                        .preferredSize(80.dp, 80.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp)
                ) {
                    val typography = MaterialTheme.typography
                    Text(
                        text = artist.name.toUpperCase(),
                        style = typography.h6,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = artist.gender,
                        style = TextStyle(
                            color = Color.Gray,
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Medium,
                            fontSize = typography.subtitle1.fontSize
                        )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewArtistCard() {
    val artist = Artist(
        imageResource = R.drawable.shakira,
        name = "Shakira Isabel Mebarak Ripoll",
        gender = "Pop",
        phrase = "Waka waka!"
    )

    ArtistCard(artist = artist) {
        Log.v(TAG, "Clicked!")
    }
}