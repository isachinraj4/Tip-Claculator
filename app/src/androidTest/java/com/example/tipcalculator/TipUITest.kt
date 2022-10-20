package com.example.tipcalculator

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.tipcalculator.ui.theme.TipCalculatorTheme
import org.junit.Rule
import org.junit.Test

class TipUITest {
    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            TipCalculatorTheme {
                TipCalculator()
            }
        }
        composeTestRule.onNodeWithText("Cost of Service")
            .performTextInput("100")
        composeTestRule.onNodeWithText("Tip (%)").performTextInput("15")
        composeTestRule.onNodeWithText("Tip Amount: $15.00").assertExists()
    }
}