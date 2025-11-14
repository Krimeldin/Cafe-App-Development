package com.example.cafeapp_karim.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cafeapp_karim.screens.MenuScreen
import com.example.cafeapp_karim.screens.DetailScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "menu"
    ) {
        composable("menu") {
            MenuScreen(navController = navController)
        }
        composable("detail/{coffeeName}/{coffeePrice}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("coffeeName") ?: ""
            val price = backStackEntry.arguments?.getString("coffeePrice") ?: ""
            DetailScreen(name, price, navController)
        }
    }
}
