package fr.chezbazar.aoc23.day11

import fr.chezbazar.aoc23.Point
import fr.chezbazar.aoc23.computeFromIndexed

fun main() {
    val galaxyMap = mutableListOf<Point>()
    computeFromIndexed("day11/input.txt") { y, line ->
        line.forEachIndexed { x, c ->
            if (c == '#') {
                galaxyMap.add(Point(x, y))
            }
        }
    }
    val bigExpansionGalaxy = galaxyMap.toMutableList()
    galaxyMap.expandGalaxy(1)
    bigExpansionGalaxy.expandGalaxy(999_999)
    println(galaxyMap.computeDistances().sum()/2)
    println(bigExpansionGalaxy.computeDistances().sum()/2)
}

fun MutableList<Point>.expandGalaxy(amount: Int) {
    val expandedX = (0..<this.maxOf { it.x }).filter { value -> this.none { it.x == value } }
    val expandedY = (0..<this.maxOf { it.y }).filter { value -> this.none { it.y == value } }
    this.forEachIndexed { index, point ->
        this[index] = point + Point(amount * expandedX.filter { it < point.x }.size, amount * expandedY.filter { it < point.y }.size)
    }
}

fun List<Point>.computeDistances() = this.map { point -> this.sumOf { it.distanceTo(point).toLong() } }