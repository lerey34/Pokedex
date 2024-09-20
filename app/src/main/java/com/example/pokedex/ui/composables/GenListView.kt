package com.example.pokedex.ui.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedex.model.PokedexResults
import com.example.pokedex.model.Pokemon

@Composable
fun GenListView(results: PokedexResults) {
    val gen1 = mutableListOf<Pokemon>()
    val gen2 = mutableListOf<Pokemon>()
    val gen3 = mutableListOf<Pokemon>()
    val gen4 = mutableListOf<Pokemon>()
    val gen5 = mutableListOf<Pokemon>()
    val gen6 = mutableListOf<Pokemon>()
    val gen7 = mutableListOf<Pokemon>()
    val gen8 = mutableListOf<Pokemon>()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        results.list.forEach {
            when(it.apiGeneration){
                1 -> gen1.add(it)
                2 -> gen2.add(it)
                3 -> gen3.add(it)
                4 -> gen4.add(it)
                5 -> gen5.add(it)
                6 -> gen6.add(it)
                7 -> gen7.add(it)
                8 -> gen8.add(it)
            }
        }
        item {
            Text(text = "Génération 1 : ", color = Color.White)
            LazyRow() {
                items(gen1){pokemon ->
                    PokemonView(pokemon = pokemon, onClick = {}, modifier = Modifier.padding(8.dp))
                }
            }
            Text(text = "Génération 2 : ", color = Color.White)
            LazyRow() {
                items(gen2){pokemon ->
                    PokemonView(pokemon = pokemon, onClick = {}, modifier = Modifier.padding(8.dp))
                }
            }
            Text(text = "Génération 3 : ", color = Color.White)
            LazyRow() {
                items(gen3){pokemon ->
                    PokemonView(pokemon = pokemon, onClick = {}, modifier = Modifier.padding(8.dp))
                }
            }
            Text(text = "Génération 4 : ", color = Color.White)
            LazyRow() {
                items(gen4){pokemon ->
                    PokemonView(pokemon = pokemon, onClick = {}, modifier = Modifier.padding(8.dp))
                }
            }
            Text(text = "Génération 5 : ", color = Color.White)
            LazyRow() {
                items(gen5){pokemon ->
                    PokemonView(pokemon = pokemon, onClick = {}, modifier = Modifier.padding(8.dp))
                }
            }
            Text(text = "Génération 6 : ", color = Color.White)
            LazyRow() {
                items(gen6){pokemon ->
                    PokemonView(pokemon = pokemon, onClick = {}, modifier = Modifier.padding(8.dp))
                }
            }
            Text(text = "Génération 7 : ", color = Color.White)
            LazyRow() {
                items(gen7){pokemon ->
                    PokemonView(pokemon = pokemon, onClick = {}, modifier = Modifier.padding(8.dp))
                }
            }
            Text(text = "Génération 8 : ", color = Color.White)
            LazyRow() {
                items(gen8){pokemon ->
                    PokemonView(pokemon = pokemon, onClick = {}, modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}