package com.example.cafeapp_karim.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.cafeapp_karim.data.CartItem
import com.example.cafeapp_karim.data.CoffeeItem
import com.example.cafeapp_karim.viewmodel.CartViewModel
import com.example.cafeapp_karim.R

@Composable
fun DetailScreen(
    name: String,
    price: String,
    description: String,
    navController: NavHostController,
    cartViewModel: CartViewModel = viewModel()
) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(name, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(price, style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(description, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            cartViewModel.addToCart(CartItem(name, price, description))
        }) {
            Text("Add to Cart")
        }
    }
}
