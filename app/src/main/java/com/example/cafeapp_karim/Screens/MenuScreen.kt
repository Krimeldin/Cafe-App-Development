package com.example.cafeapp_karim.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cafeapp_karim.R
import com.example.cafeapp_karim.data.CoffeeItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(navController: NavController) {
    val coffeeList = listOf(
        CoffeeItem("CakePop", "$3.50", R.drawable.CakePop),
        CoffeeItem("IcedCoffee", "$4.00", R.drawable.IcedCoffee),
        CoffeeItem("Sandwich", "$2.50", R.drawable.Sandwich),
        CoffeeItem("Doughnuts", "$4.50", R.drawable.Doughnuts)
    )

    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
    ) {
        TopAppBar(
            title = { Text("Menu", fontSize = 22.sp) }
        )

        LazyColumn(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(coffeeList) { coffee ->
                CoffeeCard(coffee) {
                    navController.navigate("detail/${coffee.name}/${coffee.price}")
                }
            }
        }
    }
}

@Composable
fun CoffeeCard(item: CoffeeItem, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable { onClick() }
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
                Text(text = item.name, style = MaterialTheme.typography.titleMedium)
                Text(text = item.price, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

