package com.example.cafeapp_karim.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import Viewmodel.CartViewModel

@Composable
fun CheckoutScreen(navController: NavHostController, cartViewModel: CartViewModel) {
    val cartItems by remember { mutableStateOf(cartViewModel.cartItems.toMutableStateList()) }
    val totalPrice = cartItems.sumOf { it.price.toDoubleOrNull() ?: 0.0 }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Text("Checkout", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(8.dp))

        if (cartItems.isEmpty()) {
            Text("No items in your cart", style = MaterialTheme.typography.bodyMedium)
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(cartItems) { item ->
                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(item.name, style = MaterialTheme.typography.titleMedium)
                                Text(item.description, style = MaterialTheme.typography.bodyMedium)
                            }
                            Text("$${item.price}", style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
            Text("Total: $${"%.2f".format(totalPrice)}", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Button(onClick = { navController.popBackStack() }) {
                    Text("Back to Cart")
                }
                Button(onClick = {
                    cartViewModel.clearCart()
                    navController.navigate("menu") {
                        popUpTo("menu") { inclusive = true }
                    }
                }) {
                    Text("Confirm Purchase")
                }
            }
        }
    }
}
