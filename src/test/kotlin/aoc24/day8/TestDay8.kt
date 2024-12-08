package aoc24.day8

import fr.chezbazar.aoc24.Coordinates
import fr.chezbazar.aoc24.day8.countAntinodes
import fr.chezbazar.aoc24.day8.countExtendedAntinodes
import fr.chezbazar.aoc24.day8.extendedAntinodesFrom
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay8 {
    private val antennas = mapOf(
        '0' to listOf(Coordinates(8, 1), Coordinates(5, 2), Coordinates(7, 3), Coordinates(4, 4)),
        'A' to listOf(Coordinates(6, 5), Coordinates(8, 8), Coordinates(9, 9)))
    private val lines = 12
    private val columns = 12

    @Test
    fun testAntinodes() {
        assertEquals(14, countAntinodes(antennas, lines, columns))
    }

    @Test
    fun testExtendedAntinodes() {
        assertEquals(34, countExtendedAntinodes(antennas, lines, columns))
    }
}