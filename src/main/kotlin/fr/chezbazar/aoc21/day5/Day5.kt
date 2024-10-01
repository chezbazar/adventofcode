package fr.chezbazar.aoc21.day5

import fr.chezbazar.aoc21.Point
import fr.chezbazar.computeFrom

const val arraySize = 1000

fun main() {
    val ranges = mutableListOf<Pair<Point, Point>>()
    computeFrom("aoc21/day5/input.txt") {line ->
        val (p1, p2) = line.split(" -> ")
        ranges.add(p1.toPoint() to p2.toPoint())
    }
    println(intersectionsStraight(arraySize, ranges))
    println(intersections(arraySize, ranges))
}

fun intersectionsStraight(arraySize: Int, ranges: List<Pair<Point, Point>>): Int {
    val grid = List(arraySize) {
        MutableList(arraySize) { 0 }
    }
    ranges.forEach { (p1, p2) ->
        p1.straightRangeTo(p2).forEach { (x,y) -> grid[x][y] += 1 }
    }
    grid.forEach { println(it) }
    return grid.sumOf { list -> list.count { it > 1 } }
}

fun intersections(arraySize: Int, ranges: List<Pair<Point, Point>>): Int {
    val grid = List(arraySize) {
        MutableList(arraySize) { 0 }
    }
    ranges.forEach { (p1, p2) ->
        p1.rangeTo(p2).forEach { (x,y) -> grid[x][y] += 1 }
    }
    grid.forEach { println(it) }
    return grid.sumOf { list -> list.count { it > 1 } }
}

fun String.toPoint() = this.split(",").map { it.toInt() }.let { (x, y) -> Point(x,y) }