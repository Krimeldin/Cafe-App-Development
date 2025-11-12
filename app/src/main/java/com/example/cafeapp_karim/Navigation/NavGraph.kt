package com.example.cafeapp_karim.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cafeapp_karim.MenuScreen

@Composable
fun CafeNavGraph() {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") { MenuScreen() }
        // Add more screens here later
        // composable("details") { DetailsScreen() }
        // composable("cart") { CartScreen() }
    }
}
