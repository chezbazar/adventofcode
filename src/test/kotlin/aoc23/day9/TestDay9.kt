package aoc23.day9

import fr.chezbazar.aoc23.day9.extrapolate
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay9 {
    val dataset = listOf(
        "0 3 6 9 12 15".split(" ").map { it.toLong() },
        "1 3 6 10 15 21".split(" ").map { it.toLong() },
        "10 13 16 21 30 45".split(" ").map { it.toLong() }
    )

    @Test
    fun testPredictions() = assertEquals(listOf(18L, 28L, 68L), dataset.map { it.extrapolate() })

    @Test
    fun testBackwardPredictions() = assertEquals(listOf(-3L, 0L, 5L), dataset.map { it.reversed().extrapolate() })
}