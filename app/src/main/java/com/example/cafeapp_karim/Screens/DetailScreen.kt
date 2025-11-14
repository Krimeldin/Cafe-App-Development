package com.example.cafeapp_karim.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cafeapp_karim.data.CartItem
import Viewmodel.CartViewModel
import kotlinx.coroutines.launch
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope

@Composable
fun DetailScreen(
    name: String,
    price: String,
    description: String,
    cartViewModel: CartViewModel,
    navController: NavHostController
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = name, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = description, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = price, style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                // Add item to cart
                cartViewModel.addToCart(CartItem(name, price, description))
                // Show snackbar
                scope.launch {
                    snackbarHostState.showSnackbar("$name added to cart")
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add to Cart")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Navigate to CartScreen
        Button(
            onClick = { navController.navigate("cart") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Go to Cart")
        }

        // SnackbarHost to display messages
        SnackbarHost(hostState = snackbarHostState)
    }
}
