package fr.chezbazar.aoc24.day5

import fr.chezbazar.computeFrom

fun main() {
    val printer = Printer()
    computeFrom("aoc24/day5/input.txt") { line ->
        printer.configLine(line)
    }
    println(printer.score())
    println(printer.incorrectScore())
}