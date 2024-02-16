package aoc23.day13

import fr.chezbazar.aoc23.day13.score
import fr.chezbazar.aoc23.day13.smudgedScore
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay13 {
    private val patternVertical = listOf(
        "#.##..##.",
        "..#.##.#.",
        "##......#",
        "##......#",
        "..#.##.#.",
        "..##..##.",
        "#.#.##.#."
    )
    private val patternHorizontal = listOf(
        "#...##..#",
        "#....#..#",
        "..##..###",
        "#####.##.",
        "#####.##.",
        "..##..###",
        "#....#..#"
    )

    @Test
    fun testScore() {
        assertEquals(5, patternVertical.score())
        assertEquals(400, patternHorizontal.score())
    }

    @Test
    fun testSmudgedScore() {
        assertEquals(300, patternVertical.smudgedScore())
        assertEquals(100, patternHorizontal.smudgedScore())
    }
}