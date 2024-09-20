package com.example.pokedex.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pokedex.R
import com.example.pokedex.model.Pokemon


@Composable
fun GenPokemonView(pokemon: Pokemon, onClick: (Pokemon) -> Unit){
    Card(
        elevation = CardDefaults.cardElevation(7.dp),
        shape = RoundedCornerShape(percent = 10),
        modifier = Modifier.clickable { onClick(pokemon) }
    ) {
        Column {
            AsyncImage(
                model = pokemon.image,
                contentDescription = null,
                placeholder = painterResource(id = R.drawable.pokeball),
            )
            Surface {
                Text(
                    text = pokemon.name,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp, bottom = 4.dp),
                )
            }
        }
    }
}