package fr.chezbazar.aoc24.day3

import fr.chezbazar.computeFrom

fun main() {
    var result = 0
    var resultWithConditions = 0
    var currentStatus = true
    computeFrom("aoc24/day3/input.txt") { line ->
        result += line.uncorruptMultiplier()
        val (toAdd, newStatus) = line.uncorruptMultiplierWithConditions(currentStatus)
        currentStatus = newStatus
        resultWithConditions += toAdd
    }
    println(result)
    println(resultWithConditions)
}

fun String.uncorruptMultiplier(): Int {
    val regex = Regex("mul\\((\\d+),(\\d+)\\)")
    val matches = regex.findAll(this)
    var result = 0
    matches.forEach { matchResult ->
        val (_, first, second) = matchResult.groupValues.map { it.toIntOrNull() ?: 0 }
        result += first * second
    }
    return result
}

fun String.uncorruptMultiplierWithConditions(initialStatus: Boolean): Pair<Int, Boolean> {
    var currentStatus = initialStatus
    val regex = Regex("mul\\((\\d+),(\\d+)\\)|do\\(\\)|don't\\(\\)")
    val matches = regex.findAll(this)
    var result = 0
    matches.forEach { matchResult ->
        when(matchResult.value) {
            "do()" -> currentStatus = true
            "don't()" -> currentStatus = false
            else -> {
                if (currentStatus) {
                    val (_, first, second) = matchResult.groupValues.map { it.toIntOrNull() ?: 0 }
                    result += first * second
                }
            }
        }
    }
    return result to currentStatus
}