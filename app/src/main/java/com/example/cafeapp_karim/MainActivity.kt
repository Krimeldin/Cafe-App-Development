package com.example.cafeapp_karim

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cafeapp_karim.ui.theme.CafeApp_KarimTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// --- MainActivity ---
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CafeApp_KarimTheme {
                CafeNavGraph()
            }
        }
    }
}

// --- Navigation Graph ---
@Composable
fun CafeNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") { MenuScreen() }
        // Add more screens here in the future
        // composable("details/{coffeeId}") { DetailsScreen(...) }
    }
}

// --- Data Model ---
data class CoffeeItem(val name: String, val price: String)

val sampleMenu = listOf(
    CoffeeItem("Cappuccino", "$3.50"),
    CoffeeItem("Latte", "$3.00"),
    CoffeeItem("Espresso", "$2.50"),
    CoffeeItem("Mocha", "$4.00")
)

// --- Menu Screen ---
@Composable
fun MenuScreen(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        item {
            Text(
                text = "Our Coffee Menu",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(16.dp)
            )
        }
        items(sampleMenu) { coffee ->
            MenuItemCard(coffee)
        }
    }
}

// --- Menu Item Card ---
@Composable
fun MenuItemCard(item: CoffeeItem) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxSize(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        androidx.compose.foundation.layout.Column(modifier = Modifier.padding(16.dp)) {
            Text(text = item.name, style = MaterialTheme.typography.titleMedium)
            Text(text = item.price, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

// --- Previews ---
@Preview(showBackground = true)
@Composable
fun MenuScreenPreview() {
    CafeApp_KarimTheme {
        MenuScreen()
    }
}



