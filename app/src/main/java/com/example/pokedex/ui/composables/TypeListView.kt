package com.example.pokedex.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pokedex.R
import com.example.pokedex.model.TypePokemon

@Composable
fun TypeListView(results: TypePokemon) {
    var config = LocalConfiguration.current
    val width = config.screenWidthDp / 2
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp)
    ) {
        LazyColumn {
            items(results.types) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Box(modifier = Modifier
                        .height(50.dp)
                        .width(width.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = it.name, color = Color.White)
                    }
                    Box(
                        modifier = Modifier
                            .height(50.dp)
                            .width(width.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        AsyncImage(
                            model = it.image,
                            contentDescription = it.name,
                            placeholder = painterResource(id = R.drawable.pokeball)
                        )
                    }
                }
                Divider(modifier = Modifier.padding(8.dp))
            }
        }
    }
}