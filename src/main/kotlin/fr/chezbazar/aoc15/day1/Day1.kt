package fr.chezbazar.aoc15.day1

import fr.chezbazar.computeFrom

fun main() {
    computeFrom("aoc15/day1/input.txt") {
        println(computeFloor(it))
        println(computeFirstBasementIndex(it))
    }
}

fun computeFloor(entry: String) = entry.count { it == '(' } - entry.count { it == ')' }

fun computeFirstBasementIndex(entry: String): Int {
    var currentFloor = 0
    var nbInstructions = 0
    entry.forEach {
        nbInstructions++
        if (it == '(') currentFloor++ else currentFloor--
        if (currentFloor < 0) return nbInstructions
    }
    throw Exception("Should have returned before")
}