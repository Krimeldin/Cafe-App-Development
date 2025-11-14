package com.example.cafeapp_karim.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.cafeapp_karim.data.CartItem
import com.example.cafeapp_karim.viewmodel.CartViewModel

@Composable
fun DetailScreen(
    coffeeName: String,
    coffeePrice: String,
    coffeeDescription: String,
    navController: NavController,
    cartViewModel: CartViewModel = viewModel()
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
        Text(coffeeName, style = MaterialTheme.typography.titleLarge)
        Text(coffeePrice, style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(coffeeDescription, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            cartViewModel.addToCart(
                CartItem(coffeeName, coffeePrice, coffeeDescription)
            )
        }) {
            Text("Add to Cart")
        }
    }
}
