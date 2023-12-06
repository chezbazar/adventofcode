package fr.chezbazar.aoc21.day7

import fr.chezbazar.aoc21.getBufferedReaderFrom
import kotlin.math.abs

fun main() {
    val crabs = getBufferedReaderFrom("day7/input.txt").readLine().split(",").map { it.toInt() }
    println(crabs.minimumFuel())
    println(crabs.minimumFuelAdjusted())
}

fun List<Int>.minimumFuel() = List(this.max() + 1) {index -> this.map { abs(it - index) }.sum() }.min()

fun List<Int>.minimumFuelAdjusted() = List(this.max() + 1) {index -> this.map { abs(it - index) * (abs(it - index) + 1) / 2 }.sum() }.min()