package com.example.pokedex.ui.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.pokedex.model.Pokemon
import com.example.pokedex.model.Screens
import com.example.pokedex.viewmodel.PokedexViewModel
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarTop(
    up: () -> Unit,
    type: Pokemon?,
    vm: PokedexViewModel = getViewModel(),
    curentScreen: Screens
){
    TopAppBar(
        title = {
            Text(text = if (curentScreen == Screens.DETAILS) vm.formatId(type?.id.toString()) else curentScreen.title, color = Color.White)
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(red = 238, green = 21, blue = 21)
        ),
        navigationIcon = {
            if (curentScreen == Screens.DETAILS){
                IconButton(onClick = { up() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
                }
            }
        }
    )
}