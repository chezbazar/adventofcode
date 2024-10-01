package aoc15.day7

import fr.chezbazar.aoc15.day7.Assembly
import kotlin.test.Test
import kotlin.test.assertEquals


class TestDay7 {

    private val circuit = listOf(
        "123 -> x",
        "456 -> y",
        "x AND y -> d",
        "x OR y -> e",
        "x LSHIFT 2 -> f",
        "y RSHIFT 2 -> g",
        "NOT x -> h",
        "NOT y -> i",
    )

    @Test
    fun testInstructions() {
        val expectedState = mapOf<String, UShort>(
            "d" to 72u,
            "e" to 507u,
            "f" to 492u,
            "g" to 114u,
            "h" to 65412u,
            "i" to 65079u,
            "x" to 123u,
            "y" to 456u,
        )
        val assembly = Assembly()
        circuit.forEach { assembly.handleInstruction(it) }
        assertEquals(expectedState, assembly.state)
    }
}