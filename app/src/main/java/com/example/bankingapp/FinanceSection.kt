package com.example.bankingapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapp.Data.FinanceData
import com.example.bankingapp.ui.theme.BlueStart
import com.example.bankingapp.ui.theme.GreenStart
import com.example.bankingapp.ui.theme.OrangeStart


val financeItems = listOf(
    FinanceData(
        name = "My\nbusiness",
        icon = Icons.Rounded.Star,
        iconBackground = OrangeStart
    ),
    FinanceData(
        name = "Finance\nanalysis",
        icon = Icons.Default.Analytics,
        iconBackground = BlueStart
    ),
    FinanceData(
        name = "My\nwallet",
        icon = Icons.Default.Wallet,
        iconBackground = GreenStart
    ),
)
@Preview
@Composable
fun FinanceSection(){
    Column {
        Text (
            text = "Finance Section",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        LazyRow (
            modifier = Modifier.padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            items(financeItems.size){index->
                DisplayCard(index)
            }
        }
    }
}
@Composable
fun DisplayCard(item: Int){
    val financeItem = financeItems[item]
    var lastPaddingSize = 0.dp;
    if (item == financeItems.size){
        lastPaddingSize = 16.dp
    }
    Box(modifier = Modifier.size(120.dp).clip(RoundedCornerShape(20.dp)).background(MaterialTheme.colorScheme.secondaryContainer).clickable {}){

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(top = 10.dp, bottom = 10.dp, start = 10.dp, end = 12.dp)
        ,
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        Box( modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(financeItem.iconBackground)
            .padding(6.dp)){
            Icon(imageVector = financeItem.icon, contentDescription = financeItem.name, tint = Color.White)
        }
            Text(text = financeItem.name, color = MaterialTheme.colorScheme.onSecondaryContainer, fontWeight = FontWeight.SemiBold, fontSize = 15.sp)

    }
    }
}