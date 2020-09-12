package com.ephelsa.github.composebasics

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.withRunningRecomposer
import androidx.compose.ui.platform.setContent
import com.ephelsa.github.composebasics.model.Artist
import com.ephelsa.github.composebasics.ui.ArtistsList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val artists = mutableListOf<Artist>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtistsList(artistsList = listOf(), onSelected = ::displayArtistPhrase)
        }

        GlobalScope.launch(Dispatchers.IO) {
            populateArtist()
        }
    }

    private suspend fun populateArtist() = withRunningRecomposer {
        delay(3000)

        artists.apply {
            add(Artist(R.drawable.shakira, "Shakira", "Pop", "Waka, Waka, Eh, eh...!"))
            add(Artist(R.drawable.mercury, "Freddie Mercury", "Rock", "Eooooooooo!"))
            add(Artist(R.drawable.avicii, "Avicii", "Electronic", "Wake me up"))
        }
    }


    private fun displayArtistPhrase(artist: Artist) {
        Toast.makeText(this, "${artist.name}: ${artist.phrase}", Toast.LENGTH_SHORT).show()
    }
}
