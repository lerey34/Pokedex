package com.example.pokedex.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.pokedex.model.PokedexResults
import com.example.pokedex.model.Pokemon

@Composable
fun PokedexView(results: PokedexResults, onClick: (Pokemon) -> Unit) {
    LazyVerticalGrid(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp),
        columns = GridCells.Fixed(2),
        content = {
            items(results.list){pokemons ->
                PokemonView(pokemon = pokemons, onClick = { onClick(it) })
            }
        }
    )
}