package aoc24.day1

import kotlin.test.Test
import kotlin.test.assertEquals
import fr.chezbazar.aoc24.day1.distance
import fr.chezbazar.aoc24.day1.similarity

class TestDay1 {
    val firstList = listOf(3, 4, 2, 1, 3, 3)
    val secondList = listOf(4, 3, 5, 3, 9, 3)

    @Test
    fun testDistance() {
        assertEquals(11, distance(firstList, secondList))
    }

    @Test
    fun testSimilarity() {
        assertEquals(31, similarity(firstList, secondList))
    }
}