package aoc23.day8

import fr.chezbazar.aoc23.day8.NetworkMap
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay8 {
    val firstMap = NetworkMap("RL")
    val secondMap = NetworkMap("LLR")
    val ghostMap = NetworkMap("LR")

    @BeforeTest
    fun setup() {
        firstMap.handleEntry("AAA = (BBB, CCC)")
        firstMap.handleEntry("BBB = (DDD, EEE)")
        firstMap.handleEntry("CCC = (ZZZ, GGG)")
        firstMap.handleEntry("DDD = (DDD, DDD)")
        firstMap.handleEntry("EEE = (EEE, EEE)")
        firstMap.handleEntry("GGG = (GGG, GGG)")
        firstMap.handleEntry("ZZZ = (ZZZ, ZZZ)")

        secondMap.handleEntry("AAA = (BBB, BBB)")
        secondMap.handleEntry("BBB = (AAA, ZZZ)")
        secondMap.handleEntry("ZZZ = (ZZZ, ZZZ)")

        ghostMap.handleEntry("11A = (11B, XXX)")
        ghostMap.handleEntry("11B = (XXX, 11Z)")
        ghostMap.handleEntry("11Z = (11B, XXX)")
        ghostMap.handleEntry("22A = (22B, XXX)")
        ghostMap.handleEntry("22B = (22C, 22C)")
        ghostMap.handleEntry("22C = (22Z, 22Z)")
        ghostMap.handleEntry("22Z = (22B, 22B)")
        ghostMap.handleEntry("XXX = (XXX, XXX)")
    }

    @Test
    fun testSteps() {
        assertEquals(2, firstMap.getSteps())
        assertEquals(6, secondMap.getSteps())
    }

    @Test
    fun testGhostSteps() = assertEquals(6L, ghostMap.getGhostSteps())
}