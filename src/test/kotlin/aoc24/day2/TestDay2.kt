package aoc24.day2

import fr.chezbazar.aoc24.day2.isProblemDampenerSafe
import fr.chezbazar.aoc24.day2.isSafe
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay2 {
    private val data = listOf(
        listOf(7, 6, 4, 2, 1),
        listOf(1, 2, 7, 8, 9),
        listOf(9, 7, 6, 2, 1),
        listOf(1, 3, 2, 4, 5),
        listOf(8, 6, 4, 4, 1),
        listOf(1, 3, 6, 7, 9),
    )

    @Test
    fun testSafe() {
        assertEquals(listOf(true, false, false, false, false, true), data.map { it.isSafe() })
    }

    @Test
    fun testProblemDampenerSafe() {
        assertEquals(listOf(true, false, false, true, true, true), data.map { it.isProblemDampenerSafe() })
    }
}