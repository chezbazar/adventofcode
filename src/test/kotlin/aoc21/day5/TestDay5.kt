package aoc21.day5

import fr.chezbazar.aoc21.Point
import fr.chezbazar.aoc21.day5.intersections
import fr.chezbazar.aoc21.day5.intersectionsStraight
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay5 {

    private val arraySize = 10
    private val ranges = listOf(
        Point(0,9) to Point(5, 9),
        Point(8,0) to Point(0, 8),
        Point(9,4) to Point(3, 4),
        Point(2,2) to Point(2, 1),
        Point(7,0) to Point(7, 4),
        Point(6,4) to Point(2, 0),
        Point(0,9) to Point(2, 9),
        Point(3,4) to Point(1, 4),
        Point(0,0) to Point(8, 8),
        Point(5,5) to Point(8, 2),
    )

    @Test
    fun testDay5() {
        assertEquals(5, intersectionsStraight(arraySize, ranges))
        assertEquals(12, intersections(arraySize, ranges))
    }
}