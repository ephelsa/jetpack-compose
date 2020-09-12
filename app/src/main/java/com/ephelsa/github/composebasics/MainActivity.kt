package com.ephelsa.github.composebasics

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    private val petList = mutableStateListOf(
        "Dog 🐶",
        "Cat 😸",
        "Mouse 🐭",
        "Rabbit 🐰"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetList(header = "Beauty pets", petList = petList) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }

        GlobalScope.launch {
            updatePetList()
        }
    }

    private suspend fun updatePetList() {
        delay(2000)
        petList.add("Fox 🦊")
    }
}

@Composable
fun PetList(
    header: String,
    petList: List<String>,
    onSelected: (String) -> Unit
) {
    Column {
        Text(text = header)
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumnFor(items = petList) { pet ->
            PetItem(pet = pet, onClick = onSelected)
        }
    }
}

@Composable
fun PetItem(pet: String, onClick: (String) -> Unit) {
    Text(
        text = pet,
        modifier = Modifier.clickable(onClick = { onClick(pet) })
    )
}
