package com.example.pokedex.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.pokedex.data.ItemData
import com.example.pokedex.model.ItemNav
import com.example.pokedex.ui.uistate.pokedexUiState
import com.example.pokedex.viewmodel.PokedexViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun AppBottomBar(
    navController: NavController,
    canNav: Boolean = true,
    vm: PokedexViewModel = getViewModel()
) {
    var selectedItemIndex by rememberSaveable {
        mutableStateOf("Pokedex")
    }

    if (canNav){
        NavigationBar {
            ItemData().item.forEach {
                NavigationBarItem(
                    selected = selectedItemIndex == it.name,
                    onClick = {
                        selectedItemIndex = it.name
                        navController.navigate(route = it.name)
                    },
                    icon = { Icon(imageVector = it.icon, contentDescription = it.name) },
                    label = { Text(text = it.name) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.White,
                        selectedTextColor = Color.White,
                        unselectedIconColor = Color.White,
                        unselectedTextColor = Color.White
                    )
                )
            }
        }
    }
}