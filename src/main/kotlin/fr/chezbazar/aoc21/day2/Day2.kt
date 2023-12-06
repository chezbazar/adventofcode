package fr.chezbazar.aoc21.day2

import fr.chezbazar.aoc21.computeFrom

fun main() {
    day2()
    day2Part2()
}

fun day2() {
    var horizontalPosition = 0
    var depth = 0
    computeFrom("day2/input.txt") {line ->
        val (direction, value) = line.split(" ")
        when(direction) {
            "forward" -> horizontalPosition += value.toInt()
            "down" -> depth += value.toInt()
            "up" -> depth -= value.toInt()
        }
    }
    println("$horizontalPosition * $depth = ${depth * horizontalPosition}")
}

fun day2Part2() {
    var horizontalPosition = 0
    var depth = 0
    var aim = 0
    computeFrom("day2/input.txt") {line ->
        val (direction, value) = line.split(" ")
        when(direction) {
            "forward" -> {
                horizontalPosition += value.toInt()
                depth += aim * value.toInt()
            }
            "down" -> aim += value.toInt()
            "up" -> aim -= value.toInt()
        }
    }
    println("$horizontalPosition * $depth = ${depth * horizontalPosition}")
}