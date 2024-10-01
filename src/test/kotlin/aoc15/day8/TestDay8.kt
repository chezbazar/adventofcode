package aoc15.day8

import fr.chezbazar.aoc15.day8.inMemorySize
import fr.chezbazar.aoc15.day8.newlyEncoded
import java.io.File
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay8 {
    @Test
    fun testInMemorySize() {
        val lines = File("src/test/kotlin/aoc15/day8/testEntries").readLines()
        assertEquals(12, lines.sumOf { it.length - it.inMemorySize() })
    }

    @Test
    fun testNewlyEncoded() {
        val lines = File("src/test/kotlin/aoc15/day8/testEntries").readLines()
        assertEquals(19, lines.sumOf { it.newlyEncoded() - it.length })
    }
}