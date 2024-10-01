package aoc15.day4

import fr.chezbazar.aoc15.day4.hashNumber
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay4 {
    @Test
    fun testMd5() {
        assertEquals(609043, "abcdef".hashNumber())
        assertEquals(1048970, "pqrstuv".hashNumber())
    }
}