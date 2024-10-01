package aoc15.day1

import fr.chezbazar.aoc15.day1.computeFirstBasementIndex
import fr.chezbazar.aoc15.day1.computeFloor
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay1 {
    @Test
    fun testFloor() {
        assertEquals(0, computeFloor("(())"))
        assertEquals(0, computeFloor("()()"))
        assertEquals(3, computeFloor("((("))
        assertEquals(3, computeFloor("(()(()("))
        assertEquals(3, computeFloor("))((((("))
        assertEquals(-1, computeFloor("())"))
        assertEquals(-1, computeFloor("))("))
        assertEquals(-3, computeFloor(")))"))
        assertEquals(-3, computeFloor(")())())"))
    }

    @Test
    fun testBasementDetection() {
        assertEquals(1, computeFirstBasementIndex(")"))
        assertEquals(5, computeFirstBasementIndex("()())"))
    }
}