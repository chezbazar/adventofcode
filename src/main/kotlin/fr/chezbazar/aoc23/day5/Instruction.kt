package fr.chezbazar.aoc23.day5

data class Instruction(val sourceRange: LongRange, val offset: Long) {
    fun getDestinationRange() = sourceRange.first + offset .. sourceRange.last + offset
}
