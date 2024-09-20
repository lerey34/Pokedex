package com.example.pokedex.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pokedex.R
import com.example.pokedex.model.Pokemon


@Composable
fun PokemonView(pokemon: Pokemon, onClick: (Pokemon) -> Unit, modifier: Modifier = Modifier, pageBool: Boolean = false){
    var sel by remember { mutableStateOf(true) }
    sel = pokemon.sel
    Card(
        elevation = CardDefaults.cardElevation(7.dp),
        shape = RoundedCornerShape(percent = 10),
        modifier = modifier
            .clickable {
                onClick(pokemon)
                sel = pokemon.sel
            }
            .width(100.dp)
    ) {
        Column() {
            AsyncImage(
                model = pokemon.image,
                contentDescription = null,
                colorFilter = if (!sel && pageBool) ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(0f) }) else null,
                placeholder = painterResource(id = R.drawable.pokeball),
            )
            Text(
                text = pokemon.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, bottom = 4.dp),
                textAlign = TextAlign.Center,
            )
        }
    }
}