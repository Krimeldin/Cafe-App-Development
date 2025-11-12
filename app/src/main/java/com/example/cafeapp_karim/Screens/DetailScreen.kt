package com.example.cafeapp_karim.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cafeapp_karim.data.CoffeeItem
import androidx.compose.material3.TopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(coffeeItem: CoffeeItem, navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(coffeeItem.name, fontSize = 22.sp) }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = coffeeItem.imageRes),
                contentDescription = coffeeItem.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Price: ${coffeeItem.price}",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Delicious ${coffeeItem.name} to brighten your day!",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = { navController.popBackStack() }) {
                Text("Back to Menu")
            }
        }
    }
}
