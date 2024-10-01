package fr.chezbazar.aoc15.day6

import fr.chezbazar.aoc15.Point
import kotlin.math.max
import kotlin.math.min

class LightGrid {
    private val grid = MutableList(1000) { MutableList(1000) { 0 } }

    fun litLights() = grid.sumOf { gridRow -> gridRow.sum() }

    fun turnOn(from: Point, to: Point) = execOnRanges(from, to) { x, y ->
        grid[x][y] = grid[x][y] + 1
    }

    fun turnOff(from: Point, to: Point) = execOnRanges(from, to) { x, y ->
        grid[x][y] = max(0, grid[x][y] - 1)
    }

    fun toggle(from: Point, to: Point) = execOnRanges(from, to) { x, y ->
        grid[x][y] = grid[x][y] + 2
    }
// First half
//    private val grid = MutableList(1000) { MutableList(1000) { false } }
//
//    fun litLights() = grid.sumOf { gridRow -> gridRow.count { it } }
//
//    fun turnOn(from: Point, to: Point) = execOnRanges(from, to) { x, y ->
//        grid[x][y] = true
//    }
//
//    fun turnOff(from: Point, to: Point) = execOnRanges(from, to) { x, y ->
//        grid[x][y] = false
//    }
//
//    fun toggle(from: Point, to: Point) = execOnRanges(from, to) { x, y ->
//        grid[x][y] = !grid[x][y]
//    }

    private fun execOnRanges(from: Point, to: Point, action: (x: Int, y: Int) -> Unit) {
        val (xRange, yRange) = ranges(from, to)
        for (x in xRange) {
            for (y in yRange) {
                action(x, y)
            }
        }
    }

    private fun ranges(from: Point, to: Point) = min(from.x, to.x)..max(from.x, to.x) to min(from.y, to.y)..max(from.y, to.y)
}