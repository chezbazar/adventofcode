package fr.chezbazar.aoc23.day17

import fr.chezbazar.aoc23.Direction

data class CrucibleLine(val direction: Direction, val amount: Int) {
    companion object {
        var longestLine = 3
        var shortestLine = 0
    }
    fun availableLines() = if (amount < shortestLine) {
        listOf(CrucibleLine(direction, amount + 1))
    } else if (amount < longestLine) {
        listOf(
            CrucibleLine(direction.turnLeft(), 1),
            CrucibleLine(direction.turnRight(), 1),
            CrucibleLine(direction, amount + 1))
    } else {
        listOf(
            CrucibleLine(direction.turnLeft(), 1),
            CrucibleLine(direction.turnRight(), 1))
    }

}