package aoc23.day2

import fr.chezbazar.aoc23.day2.Game
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay2 {
    private val games = listOf(
        Game.from("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"),
        Game.from("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"),
        Game.from("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red"),
        Game.from("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red"),
        Game.from("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green")
    )

    @Test
    fun testPossibleRounds() = assertEquals(8, games.filter { it.isPossible(12,13,14) }.sumOf { it.id })

    @Test
    fun testPower() = assertEquals(2286, games.sumOf { it.power() })
}