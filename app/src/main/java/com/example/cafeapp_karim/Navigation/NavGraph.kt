package com.example.cafeapp_karim.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cafeapp_karim.screens.CartScreen
import com.example.cafeapp_karim.screens.DetailScreen
import com.example.cafeapp_karim.screens.MenuScreen
import Viewmodel.CartViewModel
import com.example.cafeapp_karim.screens.CheckoutScreen
import com.example.cafeapp_karim.screens.LoginScreen
import com.example.cafeapp_karim.screens.RegisterScreen
import com.example.cafeapp_karim.viewmodel.AuthViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun NavGraph(navController: NavHostController, cartViewModel: CartViewModel) {
    // Create AuthViewModel instance
    val authViewModel: AuthViewModel = viewModel() // <-- add this line

    NavHost(navController = navController, startDestination = "login") { // use lowercase "login" to match route

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

        composable("login") { LoginScreen(navController = navController, authViewModel = authViewModel) }
        composable("register") { RegisterScreen(navController = navController, authViewModel = authViewModel) }

        composable("cart") {
            CartScreen(cartViewModel = cartViewModel, navController = navController)
        }

        composable("checkout") {
            CheckoutScreen(navController = navController, cartViewModel = cartViewModel)
        }

    }
}

