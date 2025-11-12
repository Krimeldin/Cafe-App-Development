package com.example.cafeapp_karim

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph
import com.example.cafeapp_karim.ui.theme.CafeApp_KarimTheme
import com.example.cafeapp_karim.data.CoffeeItem

// --- MainActivity ---
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CafeApp_KarimTheme {
                val navController = androidx.navigation.compose.rememberNavController()
                NavGraph(navController = navController)
            }
        }

    }

    }
}

// --- Data Model ---
data class CoffeeItem(val name: String, val price: String, val imageRes: Int)

// --- Sample Menu (add your drawable images in res/drawable) ---
val sampleMenu = listOf(
    CoffeeItem("CakePop", "$3.50", R.drawable.CakePop),
    CoffeeItem("IcedCoffee", "$3.00", R.drawable.IcedCoffee),
    CoffeeItem("Sandwich", "$2.50", R.drawable.Sandwich),
    CoffeeItem("Doughnuts", "$4.00", R.drawable.Doughnuts)
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
            CoffeeCard(coffee)
        }
    }
}

// --- Coffee Card ---
@Composable
fun CoffeeCard(item: CoffeeItem) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.name,
                modifier = Modifier.size(64.dp)
            )
            Column(modifier = Modifier.weight(1f).padding(start = 16.dp)) {
                Text(text = item.name, style = MaterialTheme.typography.titleMedium)
                Text(text = item.price, style = MaterialTheme.typography.bodyMedium)
            }
            Button(onClick = { /* TODO: Add to cart functionality */ }) {
                Text("Add")
            }
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

