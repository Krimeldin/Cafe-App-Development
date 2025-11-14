package com.example.cafeapp_karim.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cafeapp_karim.screens.CartScreen
import com.example.cafeapp_karim.screens.DetailScreen
import com.example.cafeapp_karim.screens.MenuScreen
import com.example.cafeapp_karim.viewmodel.CartViewModel

@Composable
fun NavGraph(navController: NavHostController, cartViewModel: CartViewModel) {
    NavHost(navController = navController, startDestination = "menu") {

        composable("menu") {
            MenuScreen(navController = navController, cartViewModel = cartViewModel)
        }

        composable("detail/{coffeeName}/{coffeePrice}/{description}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("coffeeName") ?: "Unknown Coffee"
            val price = backStackEntry.arguments?.getString("coffeePrice") ?: "0.0"
            val description = backStackEntry.arguments?.getString("description") ?: ""
            DetailScreen(
                name = name,
                price = price,
                description = description,
                cartViewModel = cartViewModel,
                navController = navController
            )
        }

        composable("cart") {
            CartScreen(cartViewModel = cartViewModel, navController = navController)
        }

    }
}

