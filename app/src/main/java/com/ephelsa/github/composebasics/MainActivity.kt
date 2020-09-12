package com.ephelsa.github.composebasics

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.ephelsa.github.composebasics.model.Artist
import com.ephelsa.github.composebasics.ui.ArtistsList

class MainActivity : AppCompatActivity() {

    private val artists = listOf<Artist>(
        Artist(R.drawable.shakira, "Shakira", "Pop", "Waka, Waka, Eh, eh...!"),
        Artist(R.drawable.mercury, "Freddie Mercury", "Rock", "Eooooooooo!"),
        Artist(R.drawable.avicii, "Avicii", "Electronic", "Wake me up")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtistsList(artistsList = artists, onSelected = ::displayArtistPhrase)
        }
    }


    private fun displayArtistPhrase(artist: Artist) {
        Toast.makeText(this, "${artist.name}: ${artist.phrase}", Toast.LENGTH_SHORT).show()
    }
}
