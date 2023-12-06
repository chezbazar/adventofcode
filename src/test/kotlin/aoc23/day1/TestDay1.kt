package aoc23.day1

import fr.chezbazar.aoc23.day1.getCalibrations
import fr.chezbazar.aoc23.day1.replaceNumbers
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay1 {
    private val input = listOf("1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet")

    private val inputBis = listOf("two1nine", "eightwothree", "abcone2threexyz", "xtwone3four", "4nineeightseven2",  "zoneight234", "7pqrstsixteen")

    @Test
    fun testCalibrations() {
        assertEquals(142, input.getCalibrations().sum())
    }

    @Test
    fun testCorrectedCalibrations() {
        println(inputBis)
        println(inputBis.replaceNumbers())
        assertEquals(281, inputBis.replaceNumbers().getCalibrations().sum())
    }
}