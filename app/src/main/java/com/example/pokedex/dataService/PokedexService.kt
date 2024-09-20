package com.example.pokedex.dataService

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private val baseUrl = "https://pokebuildapi.fr/api/v1/"

private val scalarsConverterFactory = ScalarsConverterFactory.create()

private val retrofit = Retrofit
    .Builder()
    .addConverterFactory(scalarsConverterFactory)
    .baseUrl(baseUrl)
    .build()

interface PokedexService {
    @GET("pokemon")
    suspend fun getPokemon(): String

    @GET("types")
    suspend fun getTypes(): String
}

object PokemonApi{
    val service: PokedexService by lazy {
        retrofit.create(PokedexService::class.java)
    }
}