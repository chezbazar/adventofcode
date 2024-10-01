package aoc15.day5

import fr.chezbazar.aoc15.day5.isNice
import fr.chezbazar.aoc15.day5.isReallyNice
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TestDay5 {
    @Test
    fun testNiceStrings() {
        assertTrue("ugknbfddgicrmopn".isNice())
        assertTrue("aaa".isNice())
        assertFalse("jchzalrnumimnmhp".isNice())
        assertFalse("haegwjzuvuyypxyu".isNice())
        assertFalse("dvszwmarrgswjxmb".isNice())
    }

    @Test
    fun testReallyNiceStrings() {
        assertTrue("qjhvhtzxzqqjkmpb".isReallyNice())
        assertTrue("xxyxx".isReallyNice())
        assertFalse("uurcxstgmygtbstg".isReallyNice())
        assertFalse("ieodomkazucvgmuy".isReallyNice())
    }
}