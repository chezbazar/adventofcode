package fr.chezbazar.aoc23.day2

import fr.chezbazar.computeFrom

fun main() {
    val games = mutableListOf<Game>()
    computeFrom("aoc23/day2/input.txt") {
        games.add(Game.from(it))
    }
    println(games.filter { it.isPossible(12,13,14) }.sumOf { it.id })
    println(games.sumOf { it.power() })
}