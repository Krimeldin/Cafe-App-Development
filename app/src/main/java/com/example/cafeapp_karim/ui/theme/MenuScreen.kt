package com.example.cafeapp_karim.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cafeapp_karim.R

data class CoffeeItem(val name: String, val price: String, val imageRes: Int)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen() {
    val coffeeList = listOf(
        CoffeeItem("Cappuccino", "$3.50", R.drawable.cappuccino),
        CoffeeItem("Latte", "$4.00", R.drawable.latte),
        CoffeeItem("Espresso", "$2.50", R.drawable.espresso),
        CoffeeItem("Mocha", "$4.50", R.drawable.mocha)
    )

    Column(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
        TopAppBar(
            title = { Text("Menu", fontSize = 22.sp) }
        )

        LazyColumn(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(coffeeList) { coffee ->
                CoffeeCard(coffee)
            }
        }
    }
}

@Composable
fun CoffeeCard(item: CoffeeItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.name,
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
            )
            Column(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(text = item.name, fontSize = 20.sp)
                Text(text = item.price, fontSize = 16.sp)
            }
        }
    }
}
