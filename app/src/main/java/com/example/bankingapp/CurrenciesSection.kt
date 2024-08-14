package com.example.bankingapp

import android.graphics.Paint.Align
import android.widget.Space
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.CurrencyYen
import androidx.compose.material.icons.rounded.CurrencyYen
import androidx.compose.material.icons.rounded.Euro
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapp.Data.CurrencyData
import com.example.bankingapp.ui.theme.GreenStart

val currencies = listOf(
    CurrencyData(
        name = "USD",
        buy = 23.35f,
        sell = 23.25f,
        icon = Icons.Rounded.AttachMoney
    ),

    CurrencyData(
        name = "EUR",
        buy = 13.35f,
        sell = 13.25f,
        icon = Icons.Rounded.Euro
    ),

    CurrencyData(
        name = "YEN",
        buy = 26.35f,
        sell = 26.35f,
        icon = Icons.Rounded.CurrencyYen
    ),

    CurrencyData(
        name = "USD",
        buy = 23.35f,
        sell = 23.25f,
        icon = Icons.Rounded.AttachMoney
    ),

    CurrencyData(
        name = "EUR",
        buy = 63.35f,
        sell = 73.25f,
        icon = Icons.Rounded.Euro
    ),

    CurrencyData(
        name = "YEN",
        buy = 16.35f,
        sell = 16.35f,
        icon = Icons.Rounded.CurrencyYen
    ),
)
@Preview
@Composable
fun CurrenciesSection() {
    var isVisible by remember { mutableStateOf(false) }
    var iconState by remember { mutableStateOf(Icons.Rounded.KeyboardArrowUp) }
    Box(
        modifier =
        Modifier
            .fillMaxSize()
            .padding(top = 32.dp),
    contentAlignment = Alignment.BottomCenter
    ){
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .animateContentSize()
    ) {


        Row(
            modifier = Modifier
                .padding(16.dp)
                .animateContentSize()
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.secondary)
                .clickable {
                    isVisible = !isVisible

                    if (isVisible) {
                        iconState = Icons.Rounded.KeyboardArrowUp
                    } else {
                        iconState = Icons.Rounded.KeyboardArrowDown
                    }
                }
            ) {

                Icon(
                    imageVector = iconState,
                    contentDescription = "Icon",
                    modifier = Modifier.size(25.dp),
                    tint = MaterialTheme.colorScheme.onSecondary
                )
            }
            Text(
                text = "Currencies",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 10.dp),
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .background(MaterialTheme.colorScheme.secondaryContainer)
        )

        if (true) {
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                    .background(MaterialTheme.colorScheme.background)
            ) {
                val boxWIthConstraintsScope = this
                val width = boxWIthConstraintsScope.maxWidth / 3
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                    ) {
                        Text(
                            text = "Currency",
                            modifier = Modifier.width(width),
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Start
                        )
                        Text(
                            text = "Buy",
                            modifier = Modifier.width(width),
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            textAlign = TextAlign.End
                        )
                        Text(
                            text = "Sell",
                            modifier = Modifier.width(width),
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            textAlign = TextAlign.End
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    LazyColumn(modifier = Modifier.fillMaxSize().heightIn(max = 60.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        items(currencies.size) { index ->
                            CurrencyItem(index, width)
                        }
                    }
                }
            }
        }

    }
    }
}

@Composable
fun CurrencyItem(index:Int,width:Dp){
    val currency = currencies[index]

    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment=Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
        ){
        Box(modifier = Modifier.width(width)){
            Box(modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(GreenStart)
                .padding(4.dp)){
                Icon(imageVector =currency.icon , contentDescription = currency.name, modifier = Modifier.size(18.dp), tint = Color.White)
            }
        }

        Text(
            text = "$ ${currency.buy}",
            modifier = Modifier.width(width),
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            textAlign = TextAlign.End
        )
        Text(
            text = "$ ${currency.sell}",
            modifier = Modifier.width(width),
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            textAlign = TextAlign.End
        )

    }
}