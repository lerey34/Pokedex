package com.example.pokedex.module

import com.example.pokedex.viewmodel.PokedexViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel{PokedexViewModel()}
}