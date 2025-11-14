package com.example.cafeapp_karim

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cafeapp_karim.screens.DetailScreen
import com.example.cafeapp_karim.screens.MenuScreen
import com.example.cafeapp_karim.ui.theme.CafeApp_KarimTheme
import com.example.cafeapp_karim.viewmodel.CartViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CafeApp_KarimTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val cartViewModel: CartViewModel = viewModel() // <-- Add CartViewModel here

    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") {
            // Pass the cartViewModel to MenuScreen so items can be added
            MenuScreen(navController, cartViewModel)
        }
        composable(
            route = "detail/{name}/{price}/{description}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("price") { type = NavType.StringType },
                navArgument("description") { type = NavType.StringType; defaultValue = "" }
            )

        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            val price = backStackEntry.arguments?.getString("price") ?: ""
            val description = backStackEntry.arguments?.getString("description") ?: ""
            DetailScreen(name = name, price = price, description = description, cartViewModel = cartViewModel, navController = navController)

        }
    }
}


