package com.ephelsa.github.composebasics.ui

import android.util.Log
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.imageResource
import androidx.ui.tooling.preview.Preview
import com.ephelsa.github.composebasics.R
import com.ephelsa.github.composebasics.model.Artist

private const val TAG = "ArtistListPreview"

@Composable
fun ArtistsList(
    artistsList: List<Artist>,
    onSelected: (Artist) -> Unit
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        LazyColumnFor(artistsList) {
            ArtistCard(artist = it, onClick = onSelected)
        }
    }
}

@Preview
@Composable
fun PreviewArtistsList() {
    val artists = listOf(
        Artist(R.drawable.shakira, "Shakira", "Pop", "Waka, Waka, Eh, eh...!"),
        Artist(R.drawable.mercury, "Freddie Mercury", "Rock", "Eooooooooo!"),
        Artist(R.drawable.avicii, "Avicii", "Electronic", "Wake me up")
    )

    ArtistsList(artistsList = artists) { artist ->
        Log.v(TAG, artist.toString())
    }
}
