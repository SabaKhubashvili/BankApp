package com.example.bankingapp.Data

import androidx.compose.ui.graphics.vector.ImageVector

data class CurrencyData (
    val name:String,
    val buy:Float,
    val sell:Float,
    val icon: ImageVector
)