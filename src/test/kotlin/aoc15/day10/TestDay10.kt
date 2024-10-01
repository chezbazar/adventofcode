package aoc15.day10

import fr.chezbazar.aoc15.day10.lookAndSay
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay10 {
    @Test
    fun testLookAndSay() {
        assertEquals("1112", "12".lookAndSay())
        var sequence = "1"
        repeat(5) {
            sequence = sequence.lookAndSay()
        }
        assertEquals("312211", sequence)
    }
}