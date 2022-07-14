package com.example.currencytap

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currencytap.ui.theme.CurrencyTAPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CurrencyTAPTheme {
                MyApp()


            }
        }
    }
}

@Composable
fun MyApp() {

    val moneyCounter = remember {
        mutableStateOf(0)
    }

    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = Color(0xFF585858)
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Text(
                text = "$${moneyCounter.value} k", style = TextStyle(
                    color = Color.White,
                    fontSize = 31.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )

            Spacer(modifier = Modifier.height(80.dp))


            CreateCircle(moneyCounter = moneyCounter.value) { newValue ->
                moneyCounter.value = newValue
            }

            Spacer(modifier = Modifier.height(80.dp))

            if (moneyCounter.value > 1500) {
                Text(
                    text = "Lots of Money. !", style = TextStyle(
                        color = Color.Cyan,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            } else {
                Text(
                    text = "gonna Be Super Rich $$$$",
                    style = TextStyle(
                        color = Color.Magenta,
                        fontSize = 16.sp,
                    )
                )
            }

        }
    }

}

@Composable
fun CreateCircle(moneyCounter: Int = 0, updatMoneyCounter: (Int) -> Unit) {


    Card(
        modifier = Modifier
            .padding(3.dp)
            .size(133.dp)
            .clickable {
                updatMoneyCounter(moneyCounter + 100)
//                moneyCounter.value += 1
//                Log.d("moneyCounter", "$moneyCounter")
            },
        shape = CircleShape,
        elevation = 4.dp
    )

    {
        Box(
            modifier = Modifier, contentAlignment = Alignment.Center
        )
        { Text(text = "Tap") }

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()

}


@Composable
fun Home() {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

    }
}





















