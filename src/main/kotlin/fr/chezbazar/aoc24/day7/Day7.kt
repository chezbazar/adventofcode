package fr.chezbazar.aoc24.day7

import fr.chezbazar.computeFrom

fun main() {
    val calibrations = mutableListOf<Calibration>()
    computeFrom("aoc24/day7/input.txt") { line ->
        calibrations.add(Calibration.from(line))
    }
    println(calibrations.filter { it.isValidLeftToRight() }.sumOf { it.result })
    println(calibrations.filter { it.isValidWithConcat() }.sumOf { it.result })
}