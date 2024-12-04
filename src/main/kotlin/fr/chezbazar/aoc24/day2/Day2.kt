package fr.chezbazar.aoc24.day2

import fr.chezbazar.computeFrom
import fr.chezbazar.withoutElementAt
import kotlin.math.abs

fun main() {
    val entries = mutableListOf<List<Int>>()
    computeFrom("aoc24/day2/input.txt") { line ->
        entries.add(line.split(" ").map { it.toInt() })
    }
    println(entries.count { it.isSafe() })
    println(entries.count { it.isProblemDampenerSafe() })
}

fun List<Int>.isSafe() = (this.differences().all { it < 0 } || this.differences().all { it > 0 })
        && this.differences().all { abs(it) in 1..3 }

private fun List<Int>.differences() = List(this.size - 1) { index -> this[index + 1] - this[index] }

fun List<Int>.isProblemDampenerSafe() = this.isSafe() || this.allCombinations().any { it.isSafe() }

private fun List<Int>.allCombinations() = List(this.size) { index ->
    this.withoutElementAt(index)
}