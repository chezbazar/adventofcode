package aoc24.day4

import fr.chezbazar.aoc24.day4.countCrossMas
import fr.chezbazar.aoc24.day4.countXmas
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay4 {
    private val testEntry = listOf(
        "MMMSXXMASM",
        "MSAMXMSMSA",
        "AMXSXMAAMM",
        "MSAMASMSMX",
        "XMASAMXAMM",
        "XXAMMXXAMA",
        "SMSMSASXSS",
        "SAXAMASAAA",
        "MAMMMXMMMM",
        "MXMXAXMASX"
    )

    @Test
    fun testCountXmas() {
        assertEquals(18, testEntry.countXmas())
    }

    @Test
    fun testCountCrossMas() {
        assertEquals(9, testEntry.countCrossMas())
    }
}