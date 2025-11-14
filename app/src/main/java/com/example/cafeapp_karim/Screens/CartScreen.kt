package com.example.cafeapp_karim.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cafeapp_karim.model.CartItem

@Composable
fun CartScreen(cartItems: List<CartItem>, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Back Button
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back"
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Screen Title
        Text("Your Cart", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(8.dp))

        if (cartItems.isEmpty()) {
            Text("Cart is empty")
        } else {
            // List of Cart Items
            cartItems.forEach { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(item.name, style = MaterialTheme.typography.subtitle1)
                        Text(item.description, style = MaterialTheme.typography.body2)
                    }
                    Text("$${item.price}", style = MaterialTheme.typography.subtitle1)
                }
                Divider()
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Total Price
            val total = cartItems.sumOf { it.price.toDoubleOrNull() ?: 0.0 }
            Text(
                "Total: $${"%.2f".format(total)}",
                style = MaterialTheme.typography.h6
            )
        }
    }
}


