package fr.chezbazar.aoc23.day1

import fr.chezbazar.aoc23.computeFrom

fun main() {
    val input = mutableListOf<String>()
    computeFrom("day1/input.txt") {
        input.add(it)
    }
    println(input.getCalibrations().sum())
    println(input.replaceNumbers().getCalibrations().sum())
}

fun List<String>.getCalibrations() = this.map { it.filter { c -> c.isDigit() } }.map { it.first().digitToInt() * 10 + it.last().digitToInt() }

fun List<String>.replaceNumbers() = this.map { it.replace("one", "on1e")
                                                        .replace("two", "tw2o")
                                                        .replace("three", "thr3ee")
                                                        .replace("four", "fo4ur")
                                                        .replace("five", "fi5ve")
                                                        .replace("six", "si6x")
                                                        .replace("seven", "se7ven")
                                                        .replace("eight", "ei8ght")
                                                        .replace("nine", "ni9ne")
}