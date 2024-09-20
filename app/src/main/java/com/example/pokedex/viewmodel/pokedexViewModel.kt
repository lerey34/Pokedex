package com.example.pokedex.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.PreferenceManager
import com.example.pokedex.dataService.PokemonApi
import com.example.pokedex.model.PokedexResults
import com.example.pokedex.model.Pokemon
import com.example.pokedex.model.TypePokemon
import com.example.pokedex.ui.uistate.pokedexUiState
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.launch
import okio.IOException

class PokedexViewModel: ViewModel() {
    var pokedexSate: pokedexUiState by mutableStateOf(pokedexUiState.LOADING)
    var genResult by mutableStateOf("")

    fun launchPokemonAPI() {
        viewModelScope.launch{
            pokedexSate = try {
                val result: String = PokemonApi.service.getPokemon()
                pokedexUiState.SUCCESS(pokemonList = convertDatasPokemon(result))
            } catch (io: IOException){
                pokedexUiState.ERROR(error = io.message?:"")
            }
        }
    }

    fun launchGenAPI() {
        viewModelScope.launch{
            pokedexSate = try {
                val result: String = PokemonApi.service.getPokemon()
                pokedexUiState.GENERATION(genList = convertDatasPokemon(result))
            } catch (io: IOException){
                pokedexUiState.ERROR(error = io.message?:"")
            }
        }
    }

    fun launchTypeAPI(){
        viewModelScope.launch {
            pokedexSate = try {
                val result: String = PokemonApi.service.getTypes()
                pokedexUiState.TYPES(typesList = convertDatasType(result))
            } catch (io: IOException){
                pokedexUiState.ERROR(error = io.message?:"")
            }
        }
    }

    fun changeSel(pokemon: Pokemon){
        pokemon.sel = !pokemon.sel
    }

    private fun convertDatasPokemon(string: String): PokedexResults {
        val list = "{\"list\": $string }"
        val perfect = list.replace("\\", "")
        val perfect2 = perfect.replace("u00c9", "É").replace("u00e9", "é").replace("u00e8", "è").replace("u2640", "♀").replace("u2642", "♂").replace("u00ef","ï")
        val gson = Gson()
        val type = object : TypeToken<PokedexResults>() {}.type
        return gson.fromJson(perfect2, type)
    }

    private fun convertDatasType(string: String): TypePokemon {
        val list = "{\"types\": $string }"
        val perfect = list.replace("\\", "")
        val perfect2 = perfect.replace("u00c9", "É").replace("u00e9", "é").replace("u00e8", "è").replace("u2640", "♀").replace("u2642", "♂").replace("u00ef","ï")
        val gson = Gson()
        val type = object : TypeToken<TypePokemon>() {}.type
        return gson.fromJson(perfect2, type)
    }

    fun formatId(id: String): String {
        val returnId: String
        return if (id.length == 1){
            returnId = "#00$id"
            returnId
        } else if(id.length == 2){
            returnId = "#0$id"
            returnId
        } else {
            returnId = "#$id"
            returnId
        }
    }
}
