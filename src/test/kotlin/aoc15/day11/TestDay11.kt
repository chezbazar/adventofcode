package aoc15.day11

import fr.chezbazar.aoc15.day11.nextValidPassword
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay11 {
    @Test
    fun testValidPassword() {
        assertEquals("abcdffaa", "abcdefgh".nextValidPassword())
        assertEquals("ghjaabcc", "ghijklmn".nextValidPassword())
    }
}