package aoc24.day5

import computeFrom
import fr.chezbazar.aoc24.day5.Printer
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay5 {
    private lateinit var printer: Printer

    @BeforeTest
    fun setup() {
        printer = Printer()
        computeFrom("aoc24/day5/input.txt") {
            printer.configLine(it)
        }
    }

    @Test
    fun testUpdateScore() {
        assertEquals(143, printer.score())
    }

    @Test
    fun testIncorrectScore() {
        assertEquals(123, printer.incorrectScore())
    }
}