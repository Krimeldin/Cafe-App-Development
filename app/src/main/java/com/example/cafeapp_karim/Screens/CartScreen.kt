package com.example.cafeapp_karim.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.cafeapp_karim.data.CartItem
import com.example.cafeapp_karim.viewmodel.CartViewModel

@Composable
fun CartScreen(cartViewModel: CartViewModel = viewModel(), navController: NavHostController) {
    val cartItems = cartViewModel.cartItems

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
        Text("Your Cart", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))

        if (cartItems.isEmpty()) {
            Text("Cart is empty")
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(cartItems) { item ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(item.name, style = MaterialTheme.typography.titleMedium)
                            Text(item.description, style = MaterialTheme.typography.bodyMedium)
                        }
                        Text(item.price, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}
