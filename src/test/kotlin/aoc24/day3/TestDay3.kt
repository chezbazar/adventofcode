package aoc24.day3

import fr.chezbazar.aoc24.day3.uncorruptMultiplier
import fr.chezbazar.aoc24.day3.uncorruptMultiplierWithConditions
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay3 {
    private val corruptedMemory = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"
    private val corruptedMemoryWithConditions = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"

    @Test
    fun testMultiplier() {
        assertEquals(161, corruptedMemory.uncorruptMultiplier())
    }

    @Test
    fun testMultiplierWithConditions() {
        assertEquals(48, corruptedMemoryWithConditions.uncorruptMultiplierWithConditions(true).first)
    }
}