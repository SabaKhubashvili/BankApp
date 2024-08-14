package com.example.bankingapp.Data

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector

data class CardsData(
    val cardType: String,
    val cardNumber: String,
    val cardName: String,
    val color: Brush,
    val balance: Double
)