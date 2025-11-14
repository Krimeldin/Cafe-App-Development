package com.example.cafeapp_karim.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.cafeapp_karim.data.CartItem
import com.example.cafeapp_karim.viewmodel.CartViewModel

@Composable
fun CartScreen(navController: NavController, cartViewModel: CartViewModel = viewModel()) {
    val cartItems = cartViewModel.cartItems

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Your Cart", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))

        if (cartItems.isEmpty()) {
            Text("Cart is empty")
        } else {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(cartItems) { item ->
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(item.name)
                            Text(item.description, style = MaterialTheme.typography.bodySmall)
                        }
                        Text(item.price)
                    }
                }
            }
        }
    }
}
