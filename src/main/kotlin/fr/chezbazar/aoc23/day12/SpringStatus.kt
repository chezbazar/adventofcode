package fr.chezbazar.aoc23.day12

enum class SpringStatus {
    BROKEN,
    UNKNOWN,
    OPERATIONAL;

    companion object {
        fun from(char: Char) = when(char) {
            '#' -> BROKEN
            '.' -> OPERATIONAL
            else -> UNKNOWN
        }
    }
}