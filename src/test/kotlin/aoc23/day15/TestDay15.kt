package aoc23.day15

import fr.chezbazar.aoc23.day15.focusingPower
import fr.chezbazar.aoc23.day15.hash
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay15 {
    private val initializationSequence = "rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7"

    @Test
    fun testHash() {
        assertEquals(52, "HASH".hash())
        assertEquals(
            listOf(30, 253, 97, 47, 14, 180, 9, 197, 48, 214, 231),
            initializationSequence.split(",").map { it.hash() }
        )
    }

    @Test
    fun testFocusingPower() {
        assertEquals(145, initializationSequence.focusingPower().mapIndexed { index, map -> (index + 1) * map.focusingPower() }.sum())
    }
}