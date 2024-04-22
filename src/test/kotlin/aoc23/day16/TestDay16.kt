package aoc23.day16

import fr.chezbazar.aoc23.Direction
import fr.chezbazar.aoc23.Point
import fr.chezbazar.aoc23.day16.Grid
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay16 {
    private val testGrid = listOf(
        ".|...\\....",
        "|.-.\\.....",
        ".....|-...",
        "........|.",
        "..........",
        ".........\\",
        "..../.\\\\..",
        ".-.-/..|..",
        ".|....-|.\\",
        "..//.|...."
    ).let { Grid.from(it) }

    @Test
    fun testEnergizingGrid() {
        testGrid.sendRay(Point(0,0), Direction.RIGHT)
        assertEquals(46, testGrid.totalEnergized())
    }
}