package fr.chezbazar.aoc15.day6

import fr.chezbazar.aoc15.Point
import fr.chezbazar.computeFrom

fun main() {
    val grid = LightGrid()
    computeFrom("aoc15/day6/input.txt") { line ->
        val regex = Regex("([\\s\\w]*) (\\d+,\\d+) through (\\d+,\\d+)")
        val (_, action, from, to) = regex.matchEntire(line)!!.groupValues
        val fromPoint = from.split(',').map { it.toInt() }.let { (x, y) -> Point(x, y) }
        val toPoint = to.split(',').map { it.toInt() }.let { (x, y) -> Point(x, y) }
        when(action) {
            "turn on" -> grid.turnOn(fromPoint, toPoint)
            "turn off" -> grid.turnOff(fromPoint, toPoint)
            "toggle" -> grid.toggle(fromPoint, toPoint)
        }
    }
    println(grid.litLights())
}