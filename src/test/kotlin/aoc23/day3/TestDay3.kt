package aoc23.day3

import fr.chezbazar.aoc23.day3.getData
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay3 {
    private val input = listOf("467..114..", "...*......", "..35..633.", "......#...", "617*......", ".....+.58.", "..592.....", "......755.", "...\$.*....", ".664.598..")

    @Test
    fun testPartNumbers() {
        val (numbers, symbols) = input.getData()
        assertEquals(4361, numbers.filter { number -> symbols.any { number.isAdjacentTo(it) } }.sumOf { it.number })
    }

    @Test
    fun testGears() {
        val (numbers, symbols) = input.getData()
        assertEquals(467835, symbols.filter { it.isGear() }.sumOf { gear ->
            val adjacentNumbers = numbers.filter { it.isAdjacentTo(gear) }
            if (adjacentNumbers.size == 2) {
                adjacentNumbers.first().number * adjacentNumbers.last().number
            } else {
                0
            }
        })
    }
}