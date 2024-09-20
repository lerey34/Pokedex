package com.example.pokedex.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.pokedex.ui.uistate.pokedexUiState
import com.example.pokedex.viewmodel.PokedexViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun GenView(vm: PokedexViewModel = getViewModel()){
    vm.launchGenAPI()
    Column {
        when(vm.pokedexSate){
            is pokedexUiState.LOADING -> LoadingView()
            is pokedexUiState.ERROR -> ErrorView(error = (vm.pokedexSate as pokedexUiState.ERROR).toString())
            is pokedexUiState.GENERATION -> GenListView(results = (vm.pokedexSate as pokedexUiState.GENERATION).genList)
        }
    }
}