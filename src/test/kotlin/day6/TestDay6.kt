package day6

import fr.chezbazar.aoc21.day6.generation
import fr.chezbazar.aoc21.day6.group
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay6 {

    private val fishes = listOf(3L,4L,3L,1L,2L)

    @Test
    fun testLanternFishes() {
        assertEquals(5934, fishes.group().generation(80).sum())
        assertEquals(26984457539L, fishes.group().generation(256).sum())
    }
}