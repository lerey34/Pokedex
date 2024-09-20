package com.example.pokedex.model

data class PokedexResults(
    val list: List<Pokemon>
)

data class Pokemon(
    val id: Int,
    val name: String,
    val image: String,
    val stats: PokemonStats,
    val apiTypes: List<apiTypes>,
    val apiGeneration: Int,
    var sel: Boolean = false
)

data class PokemonStats(
    val HP: Int,
    val attack: Int,
    val defense: Int,
    val special_attack: Int,
    val special_defense: Int,
    val speed: Int
)

data class apiTypes(
    val name: String,
    val image: String
)
data class TypePokemon(
    val types: List<TypesList>
)

data class TypesList(
    val id: Int,
    val name: String,
    val image: String
)