package aoc15.day3

import fr.chezbazar.aoc15.day3.distribute
import fr.chezbazar.aoc15.day3.getHousesSetFrom
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay3 {
    @Test
    fun testHouseDelivery() {
        assertEquals(2, getHousesSetFrom(">").size)
        assertEquals(4, getHousesSetFrom("^>v<").size)
        assertEquals(2, getHousesSetFrom("^v^v^v^v^v").size)
    }

    @Test
    fun testRobotHouseDelivery() {
        val testValues = listOf("^v" to 3, "^>v<" to 3, "^v^v^v^v^v" to 11)
        testValues.forEach { (path, expectedVal) ->
            val (santaPath, robotSantaPath) = path.distribute()
            assertEquals(expectedVal, getHousesSetFrom(santaPath).union(getHousesSetFrom(robotSantaPath)).size)
        }
    }
}