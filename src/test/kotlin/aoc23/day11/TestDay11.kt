package aoc23.day11

import fr.chezbazar.aoc23.Point
import fr.chezbazar.aoc23.day11.computeDistances
import fr.chezbazar.aoc23.day11.expandGalaxy
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay11 {
    private val galaxyMap = listOf(
        Point(3,0),
        Point(7,1),
        Point(0,2),
        Point(6,4),
        Point(1,5),
        Point(9,6),
        Point(7,8),
        Point(0,9),
        Point(4,9)
    )

    @Test
    fun testGalaxy() {
        val galaxyInUse = galaxyMap.toMutableList()
        println(galaxyInUse)
        galaxyInUse.expandGalaxy(1)
        println(galaxyInUse)
        assertEquals(374L, galaxyInUse.computeDistances().sum()/2)
    }

    @Test
    fun testBiggerGalaxy() {
        val galaxyInUse = galaxyMap.toMutableList()
        println(galaxyInUse)
        galaxyInUse.expandGalaxy(9)
        println(galaxyInUse)
        assertEquals(1030L, galaxyInUse.computeDistances().sum()/2)
    }

    @Test
    fun testEvenBiggerGalaxy() {
        val galaxyInUse = galaxyMap.toMutableList()
        println(galaxyInUse)
        galaxyInUse.expandGalaxy(99)
        println(galaxyInUse)
        assertEquals(8410L, galaxyInUse.computeDistances().sum()/2)
    }
}