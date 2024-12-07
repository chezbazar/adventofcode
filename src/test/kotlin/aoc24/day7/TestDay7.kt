package aoc24.day7

import fr.chezbazar.aoc24.day7.Calibration
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay7 {
    private val calibrations = listOf(
        Calibration(190L, listOf(10L, 19L)),
        Calibration(3267L, listOf(81, 40, 27)),
        Calibration(83L, listOf(17, 5)),
        Calibration(156L, listOf(15, 6)),
        Calibration(7290L, listOf(6, 8, 6, 15)),
        Calibration(161011L, listOf(16, 10, 13)),
        Calibration(192L, listOf(17, 8, 14)),
        Calibration(21037L, listOf(9, 7, 18, 13)),
        Calibration(292L, listOf(11, 6, 16, 20))
    )

    @Test
    fun testFindOperators() {
        assertEquals(3749L, calibrations.filter { it.isValidLeftToRight() }.sumOf { it.result })
    }

    @Test
    fun testWithConcat() {
        assertEquals(11387L, calibrations.filter { it.isValidWithConcat() }.sumOf { it.result })
    }
}