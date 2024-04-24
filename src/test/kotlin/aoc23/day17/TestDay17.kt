package aoc23.day17

import fr.chezbazar.aoc23.day17.Block
import fr.chezbazar.aoc23.day17.City
import fr.chezbazar.aoc23.day17.CrucibleLine
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay17 {
    private val input = listOf(
        "2413432311323",
        "3215453535623",
        "3255245654254",
        "3446585845452",
        "4546657867536",
        "1438598798454",
        "4457876987766",
        "3637877979653",
        "4654967986887",
        "4564679986453",
        "1224686865563",
        "2546548887735",
        "4322674655533")

    private val city = City(input.map { row -> row.map { Block(it.digitToInt()) } })

    private val alternateInput = listOf(
        "111111111111",
        "999999999991",
        "999999999991",
        "999999999991",
        "999999999991"
    )

    private val alternateCity = City(alternateInput.map { row -> row.map { Block(it.digitToInt()) } })

    @Test
    fun testDijkstra() {
        CrucibleLine.shortestLine = 0
        CrucibleLine.longestLine = 3
        assertEquals(102, city.dijkstra())
    }

    @Test
    fun testUltraCrucible() {
        CrucibleLine.shortestLine = 4
        CrucibleLine.longestLine = 10
        assertEquals(94, city.dijkstra())
        assertEquals(71, alternateCity.dijkstra())
    }
}