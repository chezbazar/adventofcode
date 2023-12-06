package fr.chezbazar.aoc23.day3

import fr.chezbazar.aoc23.Point

data class Symbol(val symbol: Char, val point: Point) {
    fun isGear() = symbol == '*'
}
