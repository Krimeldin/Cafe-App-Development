package com.example.cafeapp_karim.data

import androidx.annotation.DrawableRes

data class CoffeeItem(
    val name: String,
    val price: String,
    @DrawableRes val imageRes: Int
)
