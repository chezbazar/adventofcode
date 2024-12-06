package fr.chezbazar.aoc24.day6

import fr.chezbazar.getBufferedReaderFrom

fun main() {
    val entry = getBufferedReaderFrom("aoc24/day6/input.txt").readLines()
    val guardPath = GuardPath.from(entry)
    guardPath.patrol()
    println(guardPath.visitedTiles())
    println(guardPath.loopingWays())
}