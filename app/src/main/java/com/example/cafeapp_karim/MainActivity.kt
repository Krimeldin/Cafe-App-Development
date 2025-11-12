@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.cafeapp_karim

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cafeapp_karim.data.CoffeeItem
import com.example.cafeapp_karim.ui.theme.CafeApp_KarimTheme
import com.example.cafeapp_karim.screens.MenuScreen
import androidx.compose.material3.TopAppBar

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

    NavHost(navController = navController, startDestination = "menu") {
        // Menu Screen
        composable("menu") {
            MenuScreen(navController)
        }

        // Detail Screen with arguments
        composable(
            route = "detail/{name}/{price}/{imageRes}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("price") { type = NavType.StringType },
                navArgument("imageRes") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            val price = backStackEntry.arguments?.getString("price") ?: ""
            val imageRes = backStackEntry.arguments?.getInt("imageRes") ?: 0

            DetailScreen(
                coffeeItem = CoffeeItem(name, price, imageRes),
                navController = navController
            )
        }
    }
}

@Composable
fun DetailScreen(coffeeItem: CoffeeItem, navController: androidx.navigation.NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(coffeeItem.name, fontSize = 22.sp) }
            )
        }
    ) { padding ->
        Column(modifier = Modifier
            .padding(padding)
            .padding(16.dp)) {

            Image(
                painter = painterResource(id = coffeeItem.imageRes),
                contentDescription = coffeeItem.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Price: ${coffeeItem.price}", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Delicious ${coffeeItem.name} to brighten your day!",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = { navController.popBackStack() }) {
                Text("Back to Menu")
            }
        }
    }
}
