package aoc23.day6

import fr.chezbazar.aoc23.day6.Race
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay6 {

    private val races = listOf(Race(7, 9), Race(15,40), Race(30, 200))

    private val longRace = Race(71530, 940200)

    @Test
    fun testWinningWays() = assertEquals(listOf(4L, 8L, 9L), races.map { it.winningWays() })

    @Test
    fun testLongRace() = assertEquals(71503, longRace.winningWays())
}