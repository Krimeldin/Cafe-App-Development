package com.example.cafeapp_karim.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailScreen(name: String, price: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = name, style = MaterialTheme.typography.headlineMedium, fontSize = 28.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = price, style = MaterialTheme.typography.titleMedium, fontSize = 22.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* TODO: Add to cart */ }) {
            Text("Add to Cart")
        }
    }
}
