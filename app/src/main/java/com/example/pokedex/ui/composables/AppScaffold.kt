package com.example.pokedex.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pokedex.model.Screens
import com.example.pokedex.model.Pokemon

@Composable
fun AppScaffold(){
    val navigationController = rememberNavController()
    var type by remember { mutableStateOf<Pokemon?>(null) }
    val backStackEntry by navigationController.currentBackStackEntryAsState()
    val currentScreen = Screens.valueOf(backStackEntry?.destination?.route?: Screens.POKEDEX.name)
    Scaffold(
        topBar = {
            AppBarTop(
                up = { navigationController.navigateUp() },
                type = type,
                curentScreen = currentScreen
            )
        },
        bottomBar = { AppBottomBar(navigationController) },
        containerColor = MaterialTheme.colorScheme.surface
    ){paddingValues ->
        NavHost(
            navController = navigationController,
            startDestination = Screens.POKEDEX.name,
            modifier = Modifier.padding(paddingValues)
        ){
            composable(route = Screens.POKEDEX.name){
                AppContent(onClick = {
                    type = it
                    navigationController.navigate(route = Screens.DETAILS.name)
                })
            }
            composable(route = Screens.DETAILS.name){
                DetailView(type = type)
            }
            composable(route = Screens.TYPES.name){
                TypeView()
            }
            composable(route = Screens.GENERATIONS.name){
                GenView()
            }
        }
    }
}