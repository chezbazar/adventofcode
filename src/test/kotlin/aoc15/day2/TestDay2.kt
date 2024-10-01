package aoc15.day2

import fr.chezbazar.aoc15.day2.computeRibbon
import fr.chezbazar.aoc15.day2.computeWrappingPaper
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay2 {
    @Test
    fun testWrappingPaper() {
        assertEquals(58, computeWrappingPaper(2,3,4))
        assertEquals(43, computeWrappingPaper(1,1,10))
    }

    @Test
    fun testRibbons() {
        assertEquals(34, computeRibbon(2,3,4))
        assertEquals(14, computeRibbon(1,1,10))
    }
}