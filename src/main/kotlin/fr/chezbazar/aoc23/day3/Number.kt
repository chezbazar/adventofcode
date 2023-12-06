package fr.chezbazar.aoc23.day3

import fr.chezbazar.aoc23.RectangularRange

data class Number(val number: Int, val range: RectangularRange) {
    fun isAdjacentTo(symbol: Symbol) = range.isAdjacentTo(symbol.point)
}
