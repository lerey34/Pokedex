package com.example.pokedex.ui.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.pokedex.model.Pokemon

@Composable
fun DetailView(type: Pokemon?) {
    if (type != null){
        DetailPokemon(type = type)
    } else {
        Text(text = "Erreur de récupération des informations")
    }
}