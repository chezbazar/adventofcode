package fr.chezbazar.aoc23.day10

enum class Direction(val movement: Pair<Int, Int>) {
    EAST(1 to 0),
    WEST(-1 to 0),
    NORTH(0 to -1),
    SOUTH(0 to 1);

    fun opposite() = when(this) {
        EAST -> WEST
        WEST -> EAST
        NORTH -> SOUTH
        SOUTH -> NORTH
    }
}