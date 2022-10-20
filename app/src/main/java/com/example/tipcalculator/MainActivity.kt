package com.example.tipcalculator

import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tipcalculator.ui.theme.TipCalculatorTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TipCalculator()
                }
            }
        }
    }
}

@Composable
fun TipCalculator() {
    var billInputAmount by remember{
        mutableStateOf("")
    }
    var amount = billInputAmount.toDoubleOrNull() ?: 0.0  // ?: elvis operator to handel nullability
    var tip = tipAmountCalculator(amount)

    Column(modifier = Modifier.padding(32.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text(
            text = stringResource(id = R.string.heading),
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))
        EditNumberField(value = billInputAmount, onValueChange = {billInputAmount = it})
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = stringResource(id = R.string.tip_amount,tip),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold

        )
    }
}

@Composable
fun EditNumberField(value: String, onValueChange: (String) -> Unit) {
//    We need this in tipCalculator function to pass in tip amount when we pass it in tipCalculator it makes EditNumberFiels
//    Stateless that is call state hoisting.
//    var billInputAmount by remember{
//        mutableStateOf("")
//    }
//    var amount = billInputAmount.toDoubleOrNull() ?: 0.0  // ?: elvis operator to handel nullability
//    var tip = tipAmountCalculator(amount)
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = stringResource(id = R.string.bill)
                , modifier = Modifier.fillMaxSize()
            )
                },
        keyboardOptions = KeyboardOptions(keyboardType =  KeyboardType.Number),
        singleLine = true

        )
}

internal fun tipAmountCalculator(billAmount: Double, rateOfPer: Double = 15.0): String {
    val tip = rateOfPer/100 * billAmount
    return NumberFormat.getCurrencyInstance().format(tip)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TipCalculatorTheme {
        TipCalculator()
    }
}