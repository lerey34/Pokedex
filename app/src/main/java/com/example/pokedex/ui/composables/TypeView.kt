package com.example.pokedex.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.pokedex.ui.uistate.pokedexUiState
import com.example.pokedex.viewmodel.PokedexViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun TypeView(vm: PokedexViewModel = getViewModel()) {
    vm.launchTypeAPI()
    Column {
        when(vm.pokedexSate){
            is pokedexUiState.LOADING -> LoadingView()
            is pokedexUiState.ERROR -> ErrorView(error = (vm.pokedexSate as pokedexUiState.ERROR).toString())
            is pokedexUiState.TYPES -> TypeListView(results = (vm.pokedexSate as pokedexUiState.TYPES).typesList)
        }
    }
}