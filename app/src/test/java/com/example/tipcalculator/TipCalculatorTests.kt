package com.example.tipcalculator

import junit.framework.Assert.assertEquals
import org.junit.Test

class TipCalculatorTests {

    @Test
    fun tipCalculateTest_15_percent() {
        val billAmount = 100.00
        val tipPercent = 15.00
        val expectedTip = "$15.00"
        val actualTip = tipAmountCalculator(billAmount = billAmount, rateOfPer = tipPercent)
        assertEquals(expectedTip, actualTip)
    }
}