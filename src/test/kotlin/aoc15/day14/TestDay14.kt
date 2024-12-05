package aoc15.day14

import fr.chezbazar.aoc15.day14.Reindeer
import fr.chezbazar.aoc15.day14.raceFor
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay14 {
    @Test
    fun testReindeerRace() {
        val comet = Reindeer(14, 10, 127)
        val dancer = Reindeer(16, 11, 162)
        assertEquals(1120, comet.distanceTraveled(1000))
        assertEquals(1056, dancer.distanceTraveled(1000))
    }

    @Test
    fun testReindeerPoints() {
        val comet = Reindeer(14, 10, 127)
        val dancer = Reindeer(16, 11, 162)
        listOf(comet, dancer).raceFor(1000)
        assertEquals(689, dancer.points)
        assertEquals(312, comet.points)
    }
}