package com.example.cafeapp_karim.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(name: String?, price: String?) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = name ?: "Coffee Detail") }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Item: $name", fontSize = 24.sp)
            Text(text = "Price: $price", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { /* TODO: Add to cart functionality */ }) {
                Text("Add to Cart")
            }
        }
    }
}
