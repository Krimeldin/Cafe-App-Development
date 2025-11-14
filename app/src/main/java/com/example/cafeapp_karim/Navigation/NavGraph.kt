package com.example.cafeapp_karim.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cafeapp_karim.screens.*
import Viewmodel.CartViewModel
import com.example.cafeapp_karim.viewmodel.AuthViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    cartViewModel: CartViewModel,
    authViewModel: AuthViewModel
) {
    NavHost(navController = navController, startDestination = "login") {

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

        composable("login") {
            LoginScreen(navController = navController, authViewModel = authViewModel)
        }

        composable("register") {
            RegisterScreen(navController = navController, authViewModel = authViewModel)
        }

        composable("cart") {
            CartScreen(cartViewModel = cartViewModel, navController = navController)
        }

        composable("checkout") {
            CheckoutScreen(navController = navController, cartViewModel = cartViewModel)
        }
    }
}
