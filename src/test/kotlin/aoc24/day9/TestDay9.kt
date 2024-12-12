package aoc24.day9

import fr.chezbazar.aoc24.day9.checksum
import fr.chezbazar.aoc24.day9.unfragmentedChecksum
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay9 {
    private val diskMap = "2333133121414131402"

    @Test
    fun testChecksum() {
        assertEquals(1928L, checksum(diskMap))
    }

    @Test
    fun testUnfragmentedChecksum() {
        assertEquals(2858L, unfragmentedChecksum(diskMap))
    }
}