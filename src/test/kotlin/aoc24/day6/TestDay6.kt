package aoc24.day6

import fr.chezbazar.aoc24.day6.GuardPath
import getBufferedReaderFrom
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay6 {
    @Test
    fun testPatrol() {
        val entry = getBufferedReaderFrom("aoc24/day6/input.txt").readLines()
        val guardPath = GuardPath.from(entry)
        guardPath.patrol()
        assertEquals(41, guardPath.visitedTiles())
    }

    @Test
    fun testLoops() {
        val entry = getBufferedReaderFrom("aoc24/day6/input.txt").readLines()
        val guardPath = GuardPath.from(entry)
        guardPath.patrol()
        assertEquals(6, guardPath.loopingWays())
    }
}