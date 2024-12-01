package aoc21.day7

import fr.chezbazar.aoc21.day7.minimumFuel
import fr.chezbazar.aoc21.day7.minimumFuelAdjusted
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay7 {

    val crabs = listOf(16,1,2,0,4,2,7,1,2,14)

    @Test
    fun testCrabs() {
        assertEquals(37, crabs.minimumFuel())
        assertEquals(168, crabs.minimumFuelAdjusted())
    }

}