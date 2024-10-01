package aoc15.day6

import fr.chezbazar.aoc15.Point
import fr.chezbazar.aoc15.day6.LightGrid
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay6 {
    @Test
    fun testGrid() {
        val grid = LightGrid()
        grid.turnOn(Point(0,0), Point(2,2))
        assertEquals(9, grid.litLights())
    }
}