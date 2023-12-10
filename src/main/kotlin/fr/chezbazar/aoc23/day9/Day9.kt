package fr.chezbazar.aoc23.day9

import fr.chezbazar.aoc23.computeFrom

fun main() {
    val dataset = mutableListOf<List<Long>>()
    computeFrom("day9/input.txt") {
        dataset.add(it.split(" ").map { it.toLong() })
    }
    println(dataset.sumOf { it.extrapolate() })
    println(dataset.sumOf { it.reversed().extrapolate() })
}

fun List<Long>.extrapolate(): Long {
    val steps = mutableListOf<MutableList<Long>>()
    var currentList = this
    while (currentList.any { it != 0L }) {
        steps.add(currentList.toMutableList())
        currentList = List(currentList.size - 1) {index -> currentList[index+1] - currentList[index] }
    }
    for (i in steps.lastIndex - 1 downTo 0) {
        steps[i].add(steps[i].last() + (steps[i+1].lastOrNull() ?: 0))
    }
    return steps[0].last()
}