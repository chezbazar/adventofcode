package aoc23.day14

import fr.chezbazar.aoc23.day14.performCycle
import fr.chezbazar.aoc23.day14.performCycles
import fr.chezbazar.aoc23.day14.rockLoad
import fr.chezbazar.aoc23.day14.roll
import fr.chezbazar.aoc23.inverted
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay14 {
    private val rockMap = listOf(
        "O....#....",
        "O.OO#....#",
        ".....##...",
        "OO.#O....O",
        ".O.....O#.",
        "O.#..O.#.#",
        "..O..#O..O",
        ".......O..",
        "#....###..",
        "#OO..#...."
    )
    @Test
    fun testRockLoad() {
        assertEquals(136, rockMap.inverted().sumOf { it.roll().rockLoad() })
    }

    @Test
    fun testBillionCycles() {
        assertEquals(64, rockMap.performCycles(1_000_000_000).inverted().sumOf { it.rockLoad() })
//        var workMap = rockMap
//        repeat(20) {
//            //workMap.print()
//            println(workMap.inverted().sumOf { it.rockLoad() })
//            workMap = workMap.performCycle()
//        }
//        //workMap.print()
//        println(workMap.inverted().sumOf { it.rockLoad() })
//        val list1 = listOf("1234", "5678")
//        val list2 = listOf("1234", "5678")
//        println(list1 == list2)
    }

    private fun List<String>.print() = this.forEach { println(it) }
}