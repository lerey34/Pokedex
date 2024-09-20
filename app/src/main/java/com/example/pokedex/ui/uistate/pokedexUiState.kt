package com.example.pokedex.ui.uistate

import com.example.pokedex.model.PokedexResults
import com.example.pokedex.model.TypePokemon

interface pokedexUiState {
    object LOADING: pokedexUiState
    data class ERROR(val error: String): pokedexUiState
    data class SUCCESS(val pokemonList: PokedexResults): pokedexUiState
    data class TYPES(val typesList: TypePokemon): pokedexUiState
    data class GENERATION(val genList: PokedexResults): pokedexUiState
}