package fr.chezbazar.aoc24

enum class Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    fun rotateRight() = when(this) {
        UP -> RIGHT
        RIGHT -> DOWN
        DOWN -> LEFT
        LEFT -> UP
    }
}