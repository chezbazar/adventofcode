package aoc15.day9

import fr.chezbazar.aoc15.day9.combinations
import fr.chezbazar.aoc15.day9.extractData
import fr.chezbazar.aoc15.day9.pathDistance
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay9 {
    private val input = listOf(
        "London to Dublin = 464",
        "London to Belfast = 518",
        "Dublin to Belfast = 141"
    )

    @Test
    fun testShortestPath() {
        val (cities, distances) = extractData(input)
        assertEquals(605, cities.combinations().minOf { it.pathDistance(distances) })
    }

    @Test
    fun testLongestPath() {
        val (cities, distances) = extractData(input)
        assertEquals(982, cities.combinations().maxOf { it.pathDistance(distances) })
    }
}