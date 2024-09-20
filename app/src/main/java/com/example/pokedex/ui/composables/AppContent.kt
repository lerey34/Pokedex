package com.example.pokedex.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.pokedex.model.Pokemon
import com.example.pokedex.ui.uistate.pokedexUiState
import com.example.pokedex.viewmodel.PokedexViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun AppContent(onClick: (Pokemon) -> Unit, vm: PokedexViewModel = getViewModel()){
    vm.launchPokemonAPI()
    Column {
        when(vm.pokedexSate){
            is pokedexUiState.LOADING -> LoadingView()
            is pokedexUiState.ERROR -> ErrorView(error = (vm.pokedexSate as pokedexUiState.ERROR).toString())
            is pokedexUiState.SUCCESS -> PokedexView(results = (vm.pokedexSate as pokedexUiState.SUCCESS).pokemonList, onClick = { onClick(it) })
        }
    }
}