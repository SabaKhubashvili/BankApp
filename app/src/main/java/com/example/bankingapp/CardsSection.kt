package com.example.bankingapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapp.Data.CardsData
import com.example.bankingapp.ui.theme.BlueEnd
import com.example.bankingapp.ui.theme.BlueStart
import com.example.bankingapp.ui.theme.GreenEnd
import com.example.bankingapp.ui.theme.GreenStart
import com.example.bankingapp.ui.theme.OrangeEnd
import com.example.bankingapp.ui.theme.OrangeStart
import com.example.bankingapp.ui.theme.PurpleEnd
import com.example.bankingapp.ui.theme.PurpleStart

val cards = listOf(
    CardsData(
        cardType = "Mastercard",
        balance = 123.21,
        cardNumber = "1234 1234 1234 1234",
        cardName = "Business",
        color = getGradient(PurpleStart, PurpleEnd)
    ),
    CardsData(
        cardType = "Visa",
        balance = 11.21,
        cardNumber = "1234 1234 1234 1234",
        cardName = "Savings",
        color = getGradient(BlueStart, BlueEnd)
    ),
    CardsData(
        cardType = "Visa",
        balance = 1.21,
        cardNumber = "1234 2315 1234 1234",
        cardName = "School card",
        color = getGradient(OrangeStart, OrangeEnd)
    ),
    CardsData(
        cardType = "Mastercard",
        balance = 151.21,
        cardNumber = "1234 2315 1234 1234",
        cardName = "Trips",
        color = getGradient(GreenStart, GreenEnd)
    ),
)

@Preview
@Composable
fun CardsSection(){
    LazyRow (
        modifier = Modifier.height(160.dp)
    ){
        items(cards.size){ index ->
            CardItem(index)
        }
    }
}
@Composable
fun CardItem(index: Int){
    val card = cards[index]
    var lastItemPadding = 0.dp
    if (index == cards.size){
         lastItemPadding = 16.dp
    }
    var image = painterResource(id = R.drawable.visa)
    if (card.cardType == "Mastercard"){
        image = painterResource(id = R.drawable.mastercard)
    }

    Box(modifier = Modifier.padding(start = 16.dp,end=lastItemPadding)){
        Column(modifier = Modifier
            .clip(
                RoundedCornerShape(25.dp)
            )
            .background(card.color)
            .width(250.dp)
            .fillMaxSize()
            .heightIn(max = 160.dp)
            .clickable {}
            .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "$ ${card.balance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )

        }
    }
}


fun getGradient(startColor:Color,endColor:Color):Brush{
        return Brush.horizontalGradient(
            colors = listOf(startColor,endColor)
        )
}