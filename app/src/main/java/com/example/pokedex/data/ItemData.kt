package com.example.pokedex.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import com.example.pokedex.model.ItemNav

class ItemData {
    val item = listOf(
        ItemNav("Pokedex", Icons.Default.Home),
        ItemNav("Types", Icons.Default.List),
        ItemNav("Generations", Icons.Default.Person),
        //ItemNav("Diamant", Icons.Default.Star)
    )
}