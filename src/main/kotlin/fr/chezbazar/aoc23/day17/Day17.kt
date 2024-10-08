package fr.chezbazar.aoc23.day17

import fr.chezbazar.computeFrom

fun main() {
    val blocks = mutableListOf<List<Block>>()
    computeFrom("aoc23/day17/input.txt") {line ->
        blocks.add(line.map { Block(it.digitToInt()) })
    }
    println(City(blocks).dijkstra())
    CrucibleLine.shortestLine = 4
    CrucibleLine.longestLine = 10
    println(City(blocks).dijkstra())
}